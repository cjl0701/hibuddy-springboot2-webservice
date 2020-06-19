package com.hibuddy.springboot.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
// Spring Data Jpa에서 기본으로 제공해주는 @Query로는 다양한 조회 기능을 사용하기에 한계가 있다.
// 이 문제를 해결하기 위해서 정적 타입을 지원하는 조회 프레임워크 Querydsl을 사용한다.
// 이로써 서브쿼리, 다이나믹쿼리, 조인 등을 사용할 수 있게 된다!
// 이 설정으로 이 프로젝트에서는 어느 곳에서나 JPAQueryFactory를 주입 받아 Querydsl을 사용할 수 있게 된다.
@Configuration
public class QuerydslConfiguration {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}