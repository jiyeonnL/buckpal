package io.reflectoring.buckpal.adapter.out.persistence;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccountJpaEntity is a Querydsl query type for AccountJpaEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccountJpaEntity extends EntityPathBase<AccountJpaEntity> {

    private static final long serialVersionUID = -1563047055L;

    public static final QAccountJpaEntity accountJpaEntity = new QAccountJpaEntity("accountJpaEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QAccountJpaEntity(String variable) {
        super(AccountJpaEntity.class, forVariable(variable));
    }

    public QAccountJpaEntity(Path<? extends AccountJpaEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountJpaEntity(PathMetadata metadata) {
        super(AccountJpaEntity.class, metadata);
    }

}

