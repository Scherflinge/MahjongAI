public enum MahjongHonor {
    EAST_WIND("EW"), SOUTH_WIND("SW"), WEST_WIND("WW"), NORTH_WIND("NW"), WHITE_DRAGON("WD"), GREEN_DRAGON("GD"), RED_DRAGON("RD");

    String Name;

    MahjongHonor(String name) {
        Name = name;
    }

    public boolean IsWind() {
        return (this == EAST_WIND || this == SOUTH_WIND || this == WEST_WIND || this == NORTH_WIND);
    }

    public boolean IsDragon() {
        return (this == RED_DRAGON || this == GREEN_DRAGON || this == WHITE_DRAGON);
    }

    @Override
    public String toString() {
        return Name;
    }
}
