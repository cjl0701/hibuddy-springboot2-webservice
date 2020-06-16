package com.hibuddy.springboot.domain.hobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HobbyListRepository  extends JpaRepository<HobbyList, String> {
}
