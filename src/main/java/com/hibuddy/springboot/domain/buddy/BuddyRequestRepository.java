package com.hibuddy.springboot.domain.buddy;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuddyRequestRepository extends JpaRepository<BuddyRequest, Long> {
    Optional<BuddyRequest> findById(Long no);
}
