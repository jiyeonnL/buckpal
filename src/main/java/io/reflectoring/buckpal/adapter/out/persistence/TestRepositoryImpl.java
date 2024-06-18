package io.reflectoring.buckpal.adapter.out.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepositoryImpl implements TestRepository{

    private final JPAQueryFactory jpaQueryFactory;

    QActivityJpaEntity activity = QActivityJpaEntity.activityJpaEntity;

    public TestRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<ActivityJpaEntity> findByOwnerSinceTest(){
        return jpaQueryFactory.selectFrom(activity).where(activity.ownerAccountId.eq(1000L)).fetch();
    }

    //select a from ActivityJpaEntity a
    //where a.ownerAccountId = :ownerAccountId
    //and a.timestamp >= :since
}
