package coliving.inadapter.web;

import coliving.application.inport.RoomUseCase;
import coliving.data.dto.RoomInfo;
import coliving.data.dto.RoomQuery;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/living")
@RequiredArgsConstructor
public class RoomController {

    private final RoomUseCase roomUseCase;

    @GetMapping("/room")
    List<RoomInfo> getRoomList(@RequestParam String status){
        RoomQuery query = new RoomQuery(null, null, status);
        return roomUseCase.getRoomList(query);
    }
}
