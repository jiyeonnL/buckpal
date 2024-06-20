package coliving.application.inport;

import coliving.application.domain.Room;
import coliving.data.dto.AvailableRoomQuery;
import coliving.data.dto.ReserveRoomCommand;
import coliving.data.dto.RoomInfo;
import coliving.data.dto.RoomQuery;
import java.util.List;

public interface RoomUseCase {

    List<RoomInfo> getRoomList(RoomQuery query);

    List<RoomInfo> getAvailableRoomList(AvailableRoomQuery query);

    Room reserveRoom(ReserveRoomCommand command);


}
