import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MahjongHand {

    protected List<MahjongTile> m_Tiles;

    public MahjongHand(MahjongTile[] tiles) {
        if (tiles.length != 13) throw new IllegalArgumentException("Not Enough Tiles");

        m_Tiles = Arrays.asList(tiles);
        Collections.sort(m_Tiles);
    }

    public List<MahjongTile> getTiles()
    {
        return m_Tiles;
    }

    public int howManyTilesToTenpai()
    {
        // we need to check suits then honors
        // we can start by checking if the first tile
        return 0;
    }

}
