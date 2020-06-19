package com.hibuddy.springboot.domain.user;
// User의 CRUD를 책임지는 DAO

import com.hibuddy.springboot.web.dto.UserResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email); //email을 혼해 기회원인지 판단하기 위한 메소드
    Optional<User> findByUserId(String user_id);
    Optional<UserResponseDto> joinUserAndHobby(String user_id);
}
