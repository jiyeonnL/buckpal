package coliving.outadapter.persistence.repository;

import coliving.application.domain.Room;
import coliving.application.outport.ReservationPort;
import coliving.application.outport.LoadRoomPort;
import coliving.data.dto.AvailableRoomQuery;
import coliving.data.dto.ReserveRoomCommand;
import coliving.data.dto.RoomInfo;
import coliving.data.dto.RoomQuery;
import coliving.outadapter.persistence.entity.ReservationEntity;
import coliving.outadapter.persistence.entity.RoomEntity;
import coliving.outadapter.persistence.mapper.RoomMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomOutAdapter implements LoadRoomPort, ReservationPort {

    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public List<RoomInfo> getRoomList(RoomQuery query){
        List<RoomEntity> roomEntityList = roomRepository.findRoomList(query);
        List<RoomInfo> roomInfoList = new ArrayList<>();
        for(RoomEntity roomEntity : roomEntityList){
            roomInfoList.add(roomMapper.entityToInfo(roomEntity));
        }
        return roomInfoList;
    }

    @Override
    public List<RoomInfo> getAvailableRoomList(AvailableRoomQuery query){
        List<RoomEntity> roomEntityList = roomRepository.findAvailableRoomList(query);
        List<RoomInfo> roomInfoList = new ArrayList<>();
        for(RoomEntity roomEntity : roomEntityList){
            roomInfoList.add(roomMapper.entityToInfo(roomEntity));
        }
        return roomInfoList;
    }

    @Override
    public Room loadRoom(String roomId) {
        RoomEntity roomEntity = roomRepository.findRoomById(roomId);
        return roomMapper.entityToDomain(roomEntity);
    }


    @Override
    public boolean isAvailable(String id, String startDate, String endDate) {
        List<ReservationEntity> reservationList = roomRepository.findReservation(id, startDate, endDate);
        return reservationList.size() > 0 ? false : true;
    }

    @Override
    public void reserveRoom(ReserveRoomCommand command) {
        roomRepository.reserveRoom(command);
    }
}
