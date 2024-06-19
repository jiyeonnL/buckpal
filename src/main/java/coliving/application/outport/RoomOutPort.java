package coliving.application.outport;

import coliving.data.dto.RoomInfo;
import coliving.data.dto.RoomQuery;
import java.util.List;

public interface RoomOutPort {

    List<RoomInfo> getRoomList(RoomQuery query);


}
