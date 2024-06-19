package coliving.outadapter.persistence.mapper;

import coliving.data.dto.RoomInfo;
import coliving.outadapter.persistence.entity.Room;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public RoomInfo entityToInfo(Room room) {
        if ( room == null ) {
            return null;
        }

        String roomNumber = null;
        String roomName = null;
        Integer capacity = null;
        Integer maxCapacity = null;
        String status = null;
        String description = null;

        roomNumber = room.getNumber();
        roomName = room.getName();
        capacity = room.getBasicCapacity();
        maxCapacity = room.getMaxCapacity();
        status = room.getStatus();
        description = room.getDescription();

        RoomInfo roomInfo = new RoomInfo( roomNumber, roomName, capacity, maxCapacity, status, description );

        return roomInfo;
    }
}
