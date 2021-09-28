package model;

public class Compartment {

    private int compartmentNo;
    private int noOfRow;
    private int noOfColumn;
    private boolean isFirst;
    private boolean isLast;

    public int getNoOfRow() {
        return noOfRow;
    }

    public void setNoOfRow(int noOfRow) {
        this.noOfRow = noOfRow;
    }

    public int getNoOfColumn() {
        return noOfColumn;
    }

    public void setNoOfColumn(int noOfColumn) {
        this.noOfColumn = noOfColumn;
    }

    public int getCompartmentNo() {
        return compartmentNo;
    }

    public void setCompartmentNo(int compartmentNo) {
        this.compartmentNo = compartmentNo;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }
}
