package com.hibuddy.springboot.domain.user;
// User의 CRUD를 책임지는 DAO

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
//UserRepository에서 UserRepositoryImpl의 코드도 사용할 수 있게 됨
public interface UserRepository extends JpaRepository<User, String>, UserRepositoryCustom {
    Optional<User> findByEmail(String email); //email을 혼해 기회원인지 판단하기 위한 메소드
    Optional<User> findByUserId(String userId);

    @Transactional
    void deleteByUserId(String userId);
}
