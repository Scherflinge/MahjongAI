public class MahjongPlayer {
    enum MahjongSeat {
        EAST, SOUTH, NORTH, WEST;

        public boolean doesWindMatchSeat(MahjongHonor honor) {
            if (honor == MahjongHonor.EAST_WIND && this == EAST) return true;
            if (honor == MahjongHonor.SOUTH_WIND && this == SOUTH) return true;
            if (honor == MahjongHonor.WEST_WIND && this == WEST) return true;
            return honor == MahjongHonor.NORTH_WIND && this == NORTH;
        }
    }

    private MahjongSeat m_Seat;
    private int m_Score;
    private boolean m_inRiichi = false;
    private MahjongHand m_Hand;

    public MahjongPlayer(MahjongSeat seat, int score) {
        m_Seat = seat;
        m_Score = score;
    }

    public MahjongPlayer(MahjongSeat seat) {
        this(seat, 25000);
    }

    public boolean isInRiichi() {
        return m_inRiichi;
    }

    public void setRiichi(boolean riichi) {
        m_inRiichi = riichi;
    }

    public MahjongSeat getSeat() {
        return m_Seat;
    }

    public void incrementSeat() {
        m_Seat = MahjongSeat.values()[(m_Seat.ordinal() + 1) % MahjongSeat.values().length];
    }

    public int incrementScore(int inc) {
        m_Score += inc;
        return m_Score;
    }

    public int decrementScore(int dec) {
        m_Score -= dec;
        return m_Score;
    }

    public int getScore() {
        return m_Score;
    }

    public void setScore(int score) {
        m_Score = score;
    }

    public MahjongHand getHand() {
        return m_Hand;
    }

    public void setHand(MahjongHand hand) {
        m_Hand = hand;
    }


}
