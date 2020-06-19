package com.hibuddy.springboot.domain.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import java.util.List;
import static com.hibuddy.springboot.domain.user.QUser.user;

//항상 2개의 Repository를 의존성으로 받아야한다는 단점이 있다
@Repository
public class UserRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public UserRepositorySupport(JPAQueryFactory queryFactory) {
        super(User.class);
        this.queryFactory=queryFactory;
    }

    public List<User> findByUserId(String userId){
        return queryFactory
                .selectFrom(user)
                .where(user.userId.eq(userId))
                .fetch();
    }
}
