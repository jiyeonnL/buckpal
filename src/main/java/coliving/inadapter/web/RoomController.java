package coliving.inadapter.web;

import coliving.application.domain.Room;
import coliving.application.inport.RoomUseCase;
import coliving.data.dto.AvailableRoomQuery;
import coliving.data.dto.ReserveRoomCommand;
import coliving.data.dto.RoomInfo;
import coliving.data.dto.RoomQuery;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/living")
@RequiredArgsConstructor
public class RoomController {

    private final RoomUseCase roomUseCase;

    @GetMapping("/room")
    public List<RoomInfo> getRoomList(@RequestParam String status){
        RoomQuery query = new RoomQuery(null, null, status);
        return roomUseCase.getRoomList(query);
    }

    @GetMapping("/room/reserve")
    public List<RoomInfo> getAvailableRoomList(@RequestParam String start, String end, Integer guestNumber){
        AvailableRoomQuery query = new AvailableRoomQuery(start, end, guestNumber);
        return roomUseCase.getAvailableRoomList(query);
    }

    @PostMapping("/room")
    public Room reserveRoom(@RequestBody ReserveRoomCommand command){
        return roomUseCase.reserveRoom(command);
    }

}
