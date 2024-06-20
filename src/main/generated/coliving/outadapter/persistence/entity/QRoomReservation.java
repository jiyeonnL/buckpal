package coliving.outadapter.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoomReservation is a Querydsl query type for RoomReservation
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoomReservation extends EntityPathBase<RoomReservation> {

    private static final long serialVersionUID = 1848730793L;

    public static final QRoomReservation roomReservation = new QRoomReservation("roomReservation");

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final StringPath categoryId = createString("categoryId");

    public final NumberPath<Integer> discountAmount = createNumber("discountAmount", Integer.class);

    public final StringPath endDate = createString("endDate");

    public final StringPath farePlanId = createString("farePlanId");

    public final NumberPath<Integer> guestNumber = createNumber("guestNumber", Integer.class);

    public final StringPath id = createString("id");

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final StringPath issuedCouponId = createString("issuedCouponId");

    public final NumberPath<Integer> penalty = createNumber("penalty", Integer.class);

    public final StringPath reason = createString("reason");

    public final StringPath reservationId = createString("reservationId");

    public final StringPath roomId = createString("roomId");

    public final StringPath startDate = createString("startDate");

    public final StringPath status = createString("status");

    public final NumberPath<Integer> totalAmount = createNumber("totalAmount", Integer.class);

    public QRoomReservation(String variable) {
        super(RoomReservation.class, forVariable(variable));
    }

    public QRoomReservation(Path<? extends RoomReservation> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoomReservation(PathMetadata metadata) {
        super(RoomReservation.class, metadata);
    }

}

