package coliving.outadapter.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "RoomReservation")
public class ReservationEntity {

    @Id
    private String id;

    private String reservationId;

    private String roomId;

    private String categoryId;

    private Integer guestNumber;

    private String startDate;

    private String endDate;

    private String farePlanId;

    private Integer amount;

    private Integer totalAmount;

    private Integer penalty;

    private String issuedCouponId;

    private Integer discountAmount;

    private String status;

    private Boolean isDeleted;

    private String reason;
}
