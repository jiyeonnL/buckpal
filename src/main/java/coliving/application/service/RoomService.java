package coliving.application.service;

import coliving.application.inport.RoomUseCase;
import coliving.application.outport.RoomOutPort;
import coliving.data.dto.RoomInfo;
import coliving.data.dto.RoomQuery;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomService implements RoomUseCase {

    private final RoomOutPort roomOutPort;

    @Override
    public List<RoomInfo> getRoomList(RoomQuery query){
        return roomOutPort.getRoomList(query);
    }


}
