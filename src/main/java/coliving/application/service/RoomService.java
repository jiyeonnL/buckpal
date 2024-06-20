package coliving.application.service;

import coliving.application.domain.Room;
import coliving.application.inport.RoomUseCase;
import coliving.application.outport.ReserveRoomPort;
import coliving.application.outport.RoomOutPort;
import coliving.data.dto.AvailableRoomQuery;
import coliving.data.dto.ReserveRoomCommand;
import coliving.data.dto.RoomInfo;
import coliving.data.dto.RoomQuery;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomService implements RoomUseCase {

    private final RoomOutPort roomOutPort;
    private final ReserveRoomPort reserveRoomPort;

    @Override
    public List<RoomInfo> getRoomList(RoomQuery query){
        return roomOutPort.getRoomList(query);
    }

    @Override
    public List<RoomInfo> getAvailableRoomList(AvailableRoomQuery query){
        return roomOutPort.getAvailableRoomList(query);
    }

    @Override
    public Room reserveRoom(ReserveRoomCommand command){

        // 예약 가능한 상태인지 확인




        // 예약 대기

        // 큐로 요청 보내기


        return null;
    }


}
