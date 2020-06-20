package com.hibuddy.springboot.domain.user;

import com.hibuddy.springboot.web.dto.UserResponseDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.Projections;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.hibuddy.springboot.domain.user.QUser.user;
import static com.hibuddy.springboot.domain.user.QUserHobby.userHobby;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    //JPAQueryFactory를 주입 받아 Querydsl을 사용
    private final JPAQueryFactory queryFactory;

    @Override
    public List<User> findByUserIdToList(String userId) {
        return queryFactory.selectFrom(user)
                .where(user.userId.eq(userId))
                .fetch();
    }

    @Override
    public List<UserResponseDto> findTotalInfo(String uId) {
        return queryFactory
                .select(Projections.fields(UserResponseDto.class,
                        user.userId, user.name, user.email, user.sex, user.age, user.phone, user.nation, user.nativeLanguage, user.secondLanguage,
                        userHobby.hobby1, userHobby.hobby2, userHobby.hobby3))
                .from(user)
                .join(userHobby).on(user.userId.eq(userHobby.userId))
                .where(user.userId.eq(uId))
                .fetch();
    }
}
