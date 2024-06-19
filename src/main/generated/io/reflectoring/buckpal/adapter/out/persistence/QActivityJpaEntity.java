package io.reflectoring.buckpal.adapter.out.persistence;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QActivityJpaEntity is a Querydsl query type for ActivityJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QActivityJpaEntity extends EntityPathBase<ActivityJpaEntity> {

    private static final long serialVersionUID = -1665482289L;

    public static final QActivityJpaEntity activityJpaEntity = new QActivityJpaEntity("activityJpaEntity");

    public final NumberPath<Long> amount = createNumber("amount", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> ownerAccountId = createNumber("ownerAccountId", Long.class);

    public final NumberPath<Long> sourceAccountId = createNumber("sourceAccountId", Long.class);

    public final NumberPath<Long> targetAccountId = createNumber("targetAccountId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> timestamp = createDateTime("timestamp", java.time.LocalDateTime.class);

    public QActivityJpaEntity(String variable) {
        super(ActivityJpaEntity.class, forVariable(variable));
    }

    public QActivityJpaEntity(Path<? extends ActivityJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QActivityJpaEntity(PathMetadata metadata) {
        super(ActivityJpaEntity.class, metadata);
    }

}

