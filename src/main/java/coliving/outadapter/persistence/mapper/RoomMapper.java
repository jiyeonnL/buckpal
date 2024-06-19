package coliving.outadapter.persistence.mapper;

import coliving.data.dto.RoomInfo;
import coliving.outadapter.persistence.entity.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = ComponentModel.SPRING)
public interface RoomMapper {

    RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);


    @Mapping(source = "number", target = "roomNumber")
    @Mapping(source = "name", target = "roomName")
    @Mapping(source = "basicCapacity", target = "capacity")
    RoomInfo entityToInfo(Room room);

}
