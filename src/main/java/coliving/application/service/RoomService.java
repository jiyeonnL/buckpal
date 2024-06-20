package coliving.application.service;

import coliving.application.domain.Room;
import coliving.application.inport.RoomUseCase;
import coliving.application.outport.ReservationPort;
import coliving.application.outport.LoadRoomPort;
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

    private final LoadRoomPort loadRoomPort;
    private final ReservationPort reservationPort;

    @Override
    public List<RoomInfo> getRoomList(RoomQuery query){
        return loadRoomPort.getRoomList(query);
    }

    @Override
    public List<RoomInfo> getAvailableRoomList(AvailableRoomQuery query){
        return loadRoomPort.getAvailableRoomList(query);
    }

    @Override
    public Room reserveRoom(ReserveRoomCommand command){

        Room room = loadRoomPort.loadRoom(command.roomId());
        if(!room.isAvailable(command.startDate(), command.endDate(), command.guestNumber())){
            // 예외처리
        }

        reservationPort.reserveRoom(command);





        // 예약 대기

        // 큐로 요청 보내기


        return null;
    }


}
