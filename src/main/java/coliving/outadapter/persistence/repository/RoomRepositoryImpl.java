package coliving.outadapter.persistence.repository;

import coliving.data.dto.AvailableRoomQuery;
import coliving.data.dto.ReserveRoomCommand;
import coliving.data.dto.RoomQuery;
import coliving.outadapter.persistence.entity.QRoom;
import coliving.outadapter.persistence.entity.QRoomReservation;
import coliving.outadapter.persistence.entity.ReservationEntity;
import coliving.outadapter.persistence.entity.RoomEntity;
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
    public List<RoomEntity> findRoomList(RoomQuery query) {
        List<RoomEntity> roomEntityList = jpaQueryFactory.selectFrom(room)
                .where(room.status.eq(query.status())
                        .and(room.maxCapacity.goe(query.maxCapacity())))
                .fetch();
        return roomEntityList;
    }

    @Override
    public List<RoomEntity> findAvailableRoomList(AvailableRoomQuery query){

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

    @Override
    public RoomEntity findRoomById(String roomId){
        return jpaQueryFactory.selectFrom(room).where(room.id.eq(roomId)).fetchOne();
    }

    @Override
    public List<ReservationEntity> findReservation(String roomId, String startDate, String endDate) {
        return jpaQueryFactory.selectFrom(reservation)
                .where(reservation.roomId.eq(roomId)
                        .and(reservation.startDate.lt(endDate))
                        .and(reservation.endDate.gt(startDate)))
                .fetch();
    }

    @Override
    public void reserveRoom(ReserveRoomCommand command) {
        jpaQueryFactory.insert(reservation)
                .set(reservation.roomId, command.roomId())
                .set(reservation.startDate, command.startDate())
                .set(reservation.endDate, command.endDate())
                .execute();
    }

}
