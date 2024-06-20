package coliving.outadapter.persistence.mapper;

import coliving.application.domain.Room;
import coliving.data.dto.RoomInfo;
import coliving.outadapter.persistence.entity.RoomEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper

public interface RoomMapper {

    @Mapping(source = "number", target = "roomNumber")
    @Mapping(source = "name", target = "roomName")
    @Mapping(source = "basicCapacity", target = "capacity")
    @BeanMapping(ignoreByDefault = true)
    RoomInfo entityToInfo(RoomEntity roomEntity);


    Room entityToDomain(RoomEntity roomEntity);

}
