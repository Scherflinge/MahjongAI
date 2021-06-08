import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        List<MahjongTile> l = new ArrayList<>();
        l.add(new HonorTile(MahjongHonor.NORTH_WIND));
        l.add(new HonorTile(MahjongHonor.EAST_WIND));
        l.add(new HonorTile(MahjongHonor.GREEN_DRAGON));
        l.add(new HonorTile(MahjongHonor.WEST_WIND));
        l.add(new HonorTile(MahjongHonor.SOUTH_WIND));
        l.add(new NumberedTile(MahjongSuit.CHARACTERS, 1));
        System.out.println(Arrays.toString(l.toArray()));
        Collections.sort(l);
        System.out.println(Arrays.toString(l.toArray()));
    }
}
