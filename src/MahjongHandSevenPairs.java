public class MahjongHandSevenPairs implements IValidHand {
    @Override
    public int howManyTilesToTenpai() {
        return 0;
    }

    @Override
    public boolean canScore(MahjongTile[] tiles) {
        // just need to check if every even indexed tile is
        return false;
    }

    @Override
    public String toString()
    {
        return "Seven Pairs";
    }
}
