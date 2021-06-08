import java.util.Objects;

public class NumberedTile extends MahjongTile {

    protected MahjongSuit m_Suit;
    protected int m_Number;

    public NumberedTile(MahjongSuit suit, int number) {
        if(number >9 || number < 1) throw new IllegalArgumentException("Tile number must be between 1 and 9");

        m_Suit = suit;
        m_Number = number;
    }

    public MahjongSuit getSuit() {
        return m_Suit;
    }

    public int getNumber() {
        return m_Number;
    }

    @Override
    public String toString() {
        return m_Suit.toString() + m_Number;
    }

    @Override
    boolean isHonor() {
        return false;
    }

    @Override
    MahjongTile getCopy() {
        return new NumberedTile(m_Suit, m_Number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberedTile that = (NumberedTile) o;
        return m_Number == that.m_Number && m_Suit == that.m_Suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_Suit, m_Number);
    }

    @Override
    public int compareTo(MahjongTile t) {
        if (t == null) throw new NullPointerException();
        if (this.equals(t)) return 0;
        if (t.getClass() == HonorTile.class) return -1;
        NumberedTile that = (NumberedTile) t;
        int suitComp = that.getSuit().compareTo(getSuit());
        if(suitComp != 0) return suitComp;
        return getNumber() - that.getNumber();
    }
}

