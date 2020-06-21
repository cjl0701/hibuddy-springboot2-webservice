package com.hibuddy.springboot.domain.user;

import com.hibuddy.springboot.web.dto.SameHobbyBuddyDto;
import com.hibuddy.springboot.web.dto.UserResponseDto;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.Projections;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;


import java.util.List;
import java.util.stream.Collectors;

import static com.hibuddy.springboot.domain.user.QUser.user;
import static com.hibuddy.springboot.domain.user.QUserHobby.userHobby;
import static com.querydsl.core.types.dsl.Expressions.list;

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

    //join & dynamic query 적용
    //Querydsl의 where에 조건문을 쓰되 파라미터가 비어있다면(null), 조건절에서 생략되도록 BooleanExpression 사용
    @Override
    public List<UserResponseDto> findTotalInfo(String uId) {
        return queryFactory
                .select(Projections.fields(UserResponseDto.class,
                        user.userId, user.name, user.email, user.sex, user.age, user.phone, user.nation, user.nativeLanguage, user.secondLanguage,
                        userHobby.hobby1, userHobby.hobby2, userHobby.hobby3))
                .from(user)
                .join(userHobby).on(user.userId.eq(userHobby.userId))
                .where(eqUserId(uId))
                .fetch();
    }

    //이름이 주어지지 않으면 전체 회원 정보를 가져온다.
    private BooleanExpression eqUserId(String uId) {
        if (StringUtils.isEmpty(uId))
            return null;
        return user.userId.eq(uId);
    }

    @Override
    public List<SameHobbyBuddyDto> findByHobby(String hobby1, String hobby2, String hobby3) {
        return queryFactory
                .select(Projections.fields(SameHobbyBuddyDto.class,
                        user.userId, user.sex, user.age, user.nation, user.nativeLanguage, user.secondLanguage,
                        userHobby.hobby1, userHobby.hobby2, userHobby.hobby3))
                .from(user)
                .join(userHobby).on(user.userId.eq(userHobby.userId))
                .where(userHobby.hobby1.in(hobby1, hobby2, hobby3)
                        .or(userHobby.hobby2.in(hobby1, hobby2, hobby3))
                        .or(userHobby.hobby3.in(hobby1, hobby2, hobby3)))
                .fetch().stream().distinct().collect(Collectors.toList());//중복 제거
    }
}
