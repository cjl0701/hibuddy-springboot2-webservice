package com.hibuddy.springboot.domain.user;

import com.hibuddy.springboot.domain.user.UserHobby;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserHobbyRepository  extends JpaRepository<UserHobby, String> {
    Optional<UserHobby> findByUserId(String userId);
}
