package com.hibuddy.springboot.domain.user;


import com.hibuddy.springboot.web.dto.UserResponseDto;

import java.util.List;
//Support 방식으로 하면 항상 2개의 Repository를 의존성으로 받아야한다.
//Querydsl의 Custom Repository와 JpaRepository를 상속한 Repository가 기능을 나눠가졌기 때문.
//이를 해결하기 위해 Spring Data Jpa에서는 Custom Repository를 JpaRepository 상속 클래스에서 사용할 수 있도록 기능을 지원.
//이 인터페이스를 구현하면 UserRepository에서 UserRepositoryImpl의 코드도 사용할 수 있게 됨
public interface UserRepositoryCustom {
    List<User> findByUserIdToList(String userId);

    List<UserResponseDto> findTotalInfo(String userId);
}