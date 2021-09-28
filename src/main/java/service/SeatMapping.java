package service;

import model.Compartment;
import model.Seat;
import model.SeatArrangement;
import model.SeatType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class SeatMapping {

    public static List<Seat> fillSeatType(SeatArrangement seatArrangement) {
        List<Seat> seatList = new ArrayList<>();

        seatArrangement.getCompartmentList()
                .stream()
                .sorted(Comparator.comparingInt(Compartment::getCompartmentNo))
                .forEach(compartment -> {
                    for (int i = 0; i < compartment.getNoOfRow(); i++) {
                        for (int j = 0; j < compartment.getNoOfColumn(); j++) {
                            Seat seat = new Seat();
                            seat.setColumnNo(j);
                            seat.setRowNo(i);
                            seat.setCompartmentNo(compartment.getCompartmentNo());
                            seat.setType(checkAndGetSeatType(compartment, i, j));
                            seatList.add(seat);
                        }
                    }
                });
        return seatList;

    }

    public static List<Seat> arrangeSeats(List<Seat> seatList, int passenger) {
        AtomicInteger seatCount = new AtomicInteger(1);
        seatList.stream()
                .sorted(Comparator.comparing(Seat::getType)
                        .thenComparing(Seat::getRowNo)
                        .thenComparing(Seat::getCompartmentNo))
                .forEach(seat -> {
                    if (seatCount.get() <= passenger) {
                        seat.setNumber(seatCount.getAndIncrement());
                    }
                });
        return seatList;
    }


    private static SeatType checkAndGetSeatType(Compartment compartment, int rowNo, int columnNo) {
        if (compartment.isFirst() && columnNo == 0) {
            return SeatType.WINDOW;
        } else if (compartment.isLast() && columnNo == compartment.getNoOfColumn() - 1) {
            return SeatType.WINDOW;
        } else {
            if (columnNo == 0 || columnNo == compartment.getNoOfColumn() - 1) {
                return SeatType.AISLE;
            } else {
                return SeatType.MIDDLE;
            }
        }
    }

    public static void prcessOutput(SeatArrangement seatMap, List<Seat> arrangeSeats) {
        seatMap.getCompartmentList().stream()
                .sorted(Comparator.comparing(Compartment::getCompartmentNo))
                .forEach(compartment -> {
                    System.out.println("------------- Compartment " + compartment.getCompartmentNo() + " ---------------");
                    for (int i = 0; i < compartment.getNoOfRow(); i++) {
                        for (int j = 0; j < compartment.getNoOfColumn(); j++) {
                            int finalI = i;
                            int finalJ = j;
                            Optional<Seat> seatOptional = arrangeSeats.stream()
                                    .filter(s -> s.getCompartmentNo() == compartment.getCompartmentNo()
                                            && s.getRowNo() == finalI && s.getColumnNo() == finalJ)
                                    .findAny();
                            if (seatOptional.isPresent()) {
                                Seat seat = seatOptional.get();
                                String NA = "NA";
                                String passengerNo = seat.getNumber() != 0 ? String.valueOf(seat.getNumber()) : NA;
                                if (!passengerNo.equals(NA)) {
                                    System.out.print(passengerNo + "(" + seat.getType() + ")");
                                }
                                if (j != compartment.getNoOfColumn() - 1) {
                                    System.out.print(", ");
                                }
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("------------------------------------------");
                });
    }
}
