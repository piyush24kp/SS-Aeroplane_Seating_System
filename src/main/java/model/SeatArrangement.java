package model;

import java.util.ArrayList;
import java.util.List;

public class SeatArrangement {

    private List<Compartment> compartmentList;
    private int noOfRows;

    public List<Compartment> getCompartmentList() {
        if (compartmentList == null) {
            compartmentList = new ArrayList<Compartment>();
        }
        return compartmentList;
    }

    public void setRowArrangementList(List<Compartment> compartmentList) {
        this.compartmentList = compartmentList;
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(int noOfRows) {
        this.noOfRows = noOfRows;
    }
}
