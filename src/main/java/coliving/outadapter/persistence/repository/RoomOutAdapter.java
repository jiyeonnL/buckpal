package coliving.outadapter.persistence.repository;

import coliving.application.outport.RoomOutPort;
import coliving.data.dto.RoomInfo;
import coliving.data.dto.RoomQuery;
import coliving.outadapter.persistence.entity.Room;
import coliving.outadapter.persistence.mapper.RoomMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomOutAdapter implements RoomOutPort {

    private final RoomRepository roomRepository;

    @Override
    public List<RoomInfo> getRoomList(RoomQuery query){
        List<Room> roomList = roomRepository.findRoomList(query);
        List<RoomInfo> roomInfoList = new ArrayList<>();
        for(Room room : roomList){
            roomInfoList.add(RoomMapper.INSTANCE.entityToInfo(room));
        }
        return roomInfoList;
    }

}
