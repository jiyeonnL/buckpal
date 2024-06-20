package coliving.outadapter.persistence.repository;

import coliving.data.dto.AvailableRoomQuery;
import coliving.data.dto.RoomQuery;
import coliving.outadapter.persistence.entity.QRoom;
import coliving.outadapter.persistence.entity.QRoomReservation;
import coliving.outadapter.persistence.entity.Room;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class RoomRepositoryImpl implements RoomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    QRoom room = QRoom.room;
    QRoomReservation reservation = QRoomReservation.roomReservation;

    @Override
    public List<Room> findRoomList(RoomQuery query) {
        List<Room> roomList = jpaQueryFactory.selectFrom(room)
                .where(room.status.eq(query.status()))
                //.where(room.maximum_capacity.goe(query.maxCapacity()))
                .fetch();
        return roomList;
    }

    @Override
    public List<Room> findAvailableRoomList(AvailableRoomQuery query){

        return jpaQueryFactory.selectFrom(room)
                        .leftJoin(reservation).on(room.id.eq(reservation.roomId)
                        .and(reservation.startDate.lt(query.end()))
                        .and(reservation.endDate.gt(query.start()))
                        .and(reservation.status.ne("CANCELED"))
                        .and(reservation.isDeleted.eq(false)))
                .where(reservation.roomId.isNull()
                        .and(room.status.eq("NORMAL"))
                        .and(room.maxCapacity.gt(query.guestNumber()))
                        .and(room.isDeleted.eq(false)))
                .fetch();
    }

}
