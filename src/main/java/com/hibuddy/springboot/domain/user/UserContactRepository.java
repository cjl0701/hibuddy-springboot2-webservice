package com.hibuddy.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserContactRepository extends JpaRepository<UserContact, String>{
}
