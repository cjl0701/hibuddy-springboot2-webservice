package com.hibuddy.springboot.domain.hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HobbyListRepository  extends JpaRepository<HobbyList, String> {
}
