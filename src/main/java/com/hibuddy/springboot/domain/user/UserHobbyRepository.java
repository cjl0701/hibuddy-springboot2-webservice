package com.hibuddy.springboot.domain.user;

import com.hibuddy.springboot.domain.user.UserHobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHobbyRepository  extends JpaRepository<UserHobby, String> {
}
