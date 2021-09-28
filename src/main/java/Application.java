import model.Compartment;
import model.Seat;
import model.SeatArrangement;
import service.SeatMapping;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Application {

    static Logger log = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        log.info("Please enter the Seat details :");
        Scanner sc = new Scanner(System.in);

        log.info("No of Compartment :");
        int seatRows = sc.nextInt();

        SeatArrangement seatMap = new SeatArrangement();
        seatMap.setNoOfRows(seatRows);

        for (int i = 0; i < 1; i++) {
            for (int j = 1; j <= seatRows; j++) {
                Compartment compartment = new Compartment();
                log.info(j + " column :");
                compartment.setNoOfColumn(sc.nextInt());
                log.info(j + " row :");
                compartment.setNoOfRow(sc.nextInt());
                compartment.setCompartmentNo(j);

                if (j == 1) {
                    compartment.setFirst(true);
                }
                if (j == seatRows) {
                    compartment.setLast(true);
                }
                seatMap.getCompartmentList().add(compartment);
            }
        }


        log.info("Please enter the no of passengers : ");
        int passenger = sc.nextInt();

        //Assign seat order by Seat type in order of Aisle, windows and middle.
        List<Seat> seatList = SeatMapping.fillSeatType(seatMap);

        //Arrange seats and add passenger accordingly.
        List<Seat> arrangeSeats = SeatMapping.arrangeSeats(seatList, passenger);

        SeatMapping.prcessOutput(seatMap, arrangeSeats);

    }
}
