import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeldWait {
    public MahjongTile[] Tiles = new MahjongTile[2];

    public MeldWait(MahjongTile[] tiles) {
        if (tiles == null) throw new NullPointerException("Argument was null.");
        if (tiles.length != 2) throw new IllegalArgumentException("Not enough arguments.");
        if (tiles[0] == null || tiles[1] == null) throw new NullPointerException("Argument was null.");
        Tiles[0] = tiles[0];
        Tiles[1] = tiles[1];
    }

    public MeldWait(MahjongTile t1, MahjongTile t2) {
        if (t1 == null || t2 == null) throw new NullPointerException("Argument was null.");
        Tiles[0] = t1;
        Tiles[1] = t2;
    }

    public MahjongTile[] getTiles() {
        return Tiles;
    }

    public boolean hasValidWait() {

        // check for mismatched tiles
        if (Tiles[0].isHonor() != Tiles[1].isHonor()) {
            return false;
        }

        if (Tiles[0].isHonor()) {
            // If both tiles are honor tiles, just make sure they're the same honor tile
            return Tiles[0].equals(Tiles[1]);

        } else {
            NumberedTile[] numberedTiles = Arrays.copyOf(Tiles, Tiles.length, NumberedTile[].class);

            // If the tiles are not honors, make sure they're the same suit
            if (numberedTiles[0].getSuit() != numberedTiles[1].getSuit()) {
                return false;
            }

            // if they're the same suit, and they are the same number, then they are in a valid wait
            if (numberedTiles[0].getNumber() == numberedTiles[1].getNumber()) {
                return true;
            }

            // we now know they are not a pair, but they are the same suit, so we need to test for a straight
            int min = Math.min(numberedTiles[0].getNumber(), numberedTiles[1].getNumber());
            int max = Math.max(numberedTiles[0].getNumber(), numberedTiles[1].getNumber());

            // this allows for 0,1,2/8,9,10 but that's okay, because all we care about is the fact that it catches 1,2,3/7,8,9
            return max - min == 1 || max - min == 2;
        }
    }

    public MahjongTile[] getWaits() {

        if (!hasValidWait()) return new MahjongTile[0];

        List<MahjongTile> toReturn = new ArrayList<>();

        if (Tiles[0].equals(Tiles[1])) {
            // if the two tiles are the same, the only thing they can wait on is a
            toReturn.add(Tiles[0].getCopy());
        } else {
            // If the tiles aren't the same, but they are a valid wait, that means they must be numbered tiles, waiting on a straight
            NumberedTile[] numberedTiles = Arrays.copyOf(Tiles, Tiles.length, NumberedTile[].class);

            int max = Math.max(numberedTiles[0].getNumber(), numberedTiles[1].getNumber());
            int min = Math.min(numberedTiles[0].getNumber(), numberedTiles[1].getNumber());

            if (max - min == 2) {
                // if the 2 numbers are sandwiching a number, they can only be waiting on that 1 number
                toReturn.add(new NumberedTile(numberedTiles[0].getSuit(), max - 1));
            } else if (max - min == 1) {
                // these 2 numbers are next to each other, so we have a 2 sided wait

                // we could have 1,2 or 8,9 so check so we don't add a 10 or 0 tile

                if (min != 1) {
                    toReturn.add(new NumberedTile(numberedTiles[0].getSuit(), min - 1));
                }
                if (max != 9) {
                    toReturn.add(new NumberedTile(numberedTiles[0].getSuit(), max + 1));
                }
            }
        }

        return Arrays.copyOf(toReturn.toArray(), toReturn.size(), MahjongTile[].class);
    }
}

