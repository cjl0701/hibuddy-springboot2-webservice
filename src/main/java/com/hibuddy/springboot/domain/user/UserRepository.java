package com.hibuddy.springboot.domain.user;
// User의 CRUD를 책임지는 DAO

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUserId(String user_id);
}
