import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TileMeld {
    private MahjongTile[] Tiles = new MahjongTile[3];

    public TileMeld(MahjongTile t1, MahjongTile t2, MahjongTile t3) {
        Tiles[0] = t1;
        Tiles[2] = t3;
        Tiles[1] = t2;
    }

    public TileMeld(MeldWait meldWait, MahjongTile wait) {
        this(meldWait.getTiles()[0], meldWait.getTiles()[1], wait);
    }

    public MahjongTile[] getTiles() {
        return Tiles;
    }

    public boolean isValidMeld() {
        // if we were to remove one of the tiles, then the meld should be waiting for the third tile

        return Arrays.asList(new MeldWait(Tiles[0], Tiles[1]).getWaits()).contains(Tiles[2]);
    }
}

