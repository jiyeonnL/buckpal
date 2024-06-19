package coliving.application.inport;

import coliving.data.dto.RoomInfo;
import coliving.data.dto.RoomQuery;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public interface RoomUseCase {

    List<RoomInfo> getRoomList(@RequestParam RoomQuery query);


}
