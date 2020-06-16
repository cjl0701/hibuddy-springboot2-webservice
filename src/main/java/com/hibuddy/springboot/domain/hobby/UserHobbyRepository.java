package com.hibuddy.springboot.domain.hobby;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserHobbyRepository  extends JpaRepository<UserHobby, String> {
}
