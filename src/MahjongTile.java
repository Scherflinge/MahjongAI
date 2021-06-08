import java.security.PublicKey;
import java.util.EnumSet;

public abstract class MahjongTile implements Comparable<MahjongTile>
{
    abstract boolean isHonor();

    abstract MahjongTile getCopy();
}

