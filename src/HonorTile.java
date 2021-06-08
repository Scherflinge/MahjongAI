import java.util.Objects;

public class HonorTile extends MahjongTile {
    private MahjongHonor m_Honor;

    public HonorTile(MahjongHonor honor) {
        m_Honor = honor;
    }

    public MahjongHonor getHonor() {
        return m_Honor;
    }

    @Override
    boolean isHonor() {
        return true;
    }

    @Override
    MahjongTile getCopy() {
        return new HonorTile(m_Honor);
    }

    @Override
    public String toString() {
        return m_Honor.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HonorTile honorTile = (HonorTile) o;
        return m_Honor == honorTile.m_Honor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(m_Honor);
    }

    @Override
    public int compareTo(MahjongTile t) {
        if (t == null) throw new NullPointerException();
        if (this.equals(t)) return 0;
        if (t.getClass() == NumberedTile.class) return 1;
        return getHonor().compareTo(((HonorTile) t).getHonor());
    }
}

