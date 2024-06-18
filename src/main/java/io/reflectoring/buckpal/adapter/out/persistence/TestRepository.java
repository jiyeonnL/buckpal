package io.reflectoring.buckpal.adapter.out.persistence;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.stereotype.Repository;


public interface TestRepository {

    List<ActivityJpaEntity> findByOwnerSinceTest();

}
