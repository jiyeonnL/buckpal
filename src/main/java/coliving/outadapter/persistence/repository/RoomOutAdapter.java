package coliving.outadapter.persistence.repository;

import coliving.application.outport.ReserveRoomPort;
import coliving.application.outport.RoomOutPort;
import coliving.data.dto.AvailableRoomQuery;
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
public class RoomOutAdapter implements RoomOutPort, ReserveRoomPort {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public List<RoomInfo> getRoomList(RoomQuery query){
        List<Room> roomList = roomRepository.findRoomList(query);
        List<RoomInfo> roomInfoList = new ArrayList<>();
        for(Room room : roomList){
            roomInfoList.add(roomMapper.entityToInfo(room));
        }
        return roomInfoList;
    }

    @Override
    public List<RoomInfo> getAvailableRoomList(AvailableRoomQuery query){
        List<Room> roomList = roomRepository.findAvailableRoomList(query);
        List<RoomInfo> roomInfoList = new ArrayList<>();
        for(Room room : roomList){
            roomInfoList.add(roomMapper.entityToInfo(room));
        }
        return roomInfoList;
    }


    @Override
    public void reserveRoom(String roomId) {

    }
}
