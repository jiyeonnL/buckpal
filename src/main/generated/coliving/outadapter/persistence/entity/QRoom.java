package coliving.outadapter.persistence.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoom is a Querydsl query type for Room
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoom extends EntityPathBase<Room> {

    private static final long serialVersionUID = 373244707L;

    public static final QRoom room = new QRoom("room");

    public final StringPath accommodationId = createString("accommodationId");

    public final NumberPath<Integer> basicCapacity = createNumber("basicCapacity", Integer.class);

    public final StringPath categoryId = createString("categoryId");

    public final StringPath description = createString("description");

    public final StringPath id = createString("id");

    public final BooleanPath isDeleted = createBoolean("isDeleted");

    public final NumberPath<Integer> maxCapacity = createNumber("maxCapacity", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath number = createString("number");

    public final StringPath status = createString("status");

    public final StringPath target = createString("target");

    public final StringPath type = createString("type");

    public QRoom(String variable) {
        super(Room.class, forVariable(variable));
    }

    public QRoom(Path<? extends Room> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoom(PathMetadata metadata) {
        super(Room.class, metadata);
    }

}

