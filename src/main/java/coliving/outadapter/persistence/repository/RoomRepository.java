package coliving.outadapter.persistence.repository;

import coliving.data.dto.AvailableRoomQuery;
import coliving.data.dto.ReserveRoomCommand;
import coliving.data.dto.RoomQuery;
import coliving.outadapter.persistence.entity.ReservationEntity;
import coliving.outadapter.persistence.entity.RoomEntity;

import java.util.List;

public interface RoomRepository {

    List<RoomEntity> findRoomList(RoomQuery query);

    List<RoomEntity> findAvailableRoomList(AvailableRoomQuery query);
    
    RoomEntity findRoomById(String roomId);
    
    List<ReservationEntity> findReservation(String roomId, String startDate, String endDate);

    void reserveRoom(ReserveRoomCommand command);
}
