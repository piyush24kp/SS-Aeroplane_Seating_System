package model;

import java.util.Comparator;

public class Seat implements Comparator<SeatType> {
    private int number;
    private int rowNo;
    private int columnNo;
    private SeatType type;
    private int compartmentNo;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public int getRowNo() {
        return rowNo;
    }

    public void setRowNo(int rowNo) {
        this.rowNo = rowNo;
    }

    public int getColumnNo() {
        return columnNo;
    }

    public void setColumnNo(int columnNo) {
        this.columnNo = columnNo;
    }

    public int getCompartmentNo() {
        return compartmentNo;
    }

    public void setCompartmentNo(int compartmentNo) {
        this.compartmentNo = compartmentNo;
    }

    @Override
    public int compare(SeatType o1, SeatType o2) {
        return Integer.compare(o1.getRank(), o2.getRank());
    }
}
