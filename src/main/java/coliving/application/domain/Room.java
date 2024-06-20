package coliving.application.domain;

import coliving.application.outport.ReservationPort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Room {

    private final ReservationPort reservationPort;

    private String id;

    private String number;

    private String name;

    private String status;

    private Integer basicCapacity;

    private Integer maxCapacity;

    private List<Reservation> reservationList;


    public boolean isAvailable(String startDate, String endDate, Integer guestNumber){
        if(this.status.equals("ABNORMAL") || this.maxCapacity < guestNumber){
            return false;
        }
        return reservationPort.isAvailable(this.id, startDate, endDate);
    }



}
