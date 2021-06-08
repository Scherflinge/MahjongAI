public enum MahjongSuit {
    CHARACTERS("C"), DOTS("D"), BAMBOO("B");

    String Name;

    MahjongSuit(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return Name;
    }
}
