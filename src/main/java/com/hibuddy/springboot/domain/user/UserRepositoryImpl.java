package com.hibuddy.springboot.domain.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import java.util.List;
import static com.hibuddy.springboot.domain.user.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom{
    //JPAQueryFactory를 주입 받아 Querydsl을 사용
    private final JPAQueryFactory queryFactory;

    @Override
    public List<User> findByUserIdToList(String userId) {
        return queryFactory.selectFrom(user)
                .where(user.userId.eq(userId))
                .fetch();
    }
}
