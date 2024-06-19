package coliving.outadapter.persistence.repository;

import coliving.data.dto.RoomQuery;
import coliving.outadapter.persistence.entity.Room;
import java.util.List;

public interface RoomRepository {

    List<Room> findRoomList(RoomQuery query);

}
