package coliving.outadapter.persistence.repository;

import coliving.data.dto.RoomQuery;
import coliving.outadapter.persistence.entity.QRoom;
import coliving.outadapter.persistence.entity.Room;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class RoomRepositoryImpl implements RoomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    QRoom room = QRoom.room;

    @Override
    public List<Room> findRoomList(RoomQuery query) {
        List<Room> roomList = jpaQueryFactory.selectFrom(room)
                .where(room.status.eq(query.status()))
                //.where(room.maximum_capacity.goe(query.maxCapacity()))
                .fetch();
        return roomList;
    }
}
