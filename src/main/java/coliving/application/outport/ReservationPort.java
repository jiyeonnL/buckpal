package coliving.application.outport;

import coliving.data.dto.ReserveRoomCommand;

public interface ReservationPort {

    boolean isAvailable(String id, String startDate, String endDate);

    void reserveRoom(ReserveRoomCommand command);



}
