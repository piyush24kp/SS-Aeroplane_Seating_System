package model;

public enum SeatType {
    AISLE(3),
    WINDOW(2),
    MIDDLE(3);

    private final int rank;

    SeatType(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
