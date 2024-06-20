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
@Table(name = "Room")
public class RoomEntity {

    @Id
    private String id;

    private String accommodationId;

    private String categoryId;

    private String number;

    private String name;

    private Integer basicCapacity;

    private Integer maxCapacity;

    private String type;

    private String description;

    private String status;

    private Boolean isDeleted;

    private String target;
}
