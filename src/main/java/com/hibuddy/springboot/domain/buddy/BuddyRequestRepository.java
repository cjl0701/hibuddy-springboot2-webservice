package com.hibuddy.springboot.domain.buddy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BuddyRequestRepository extends JpaRepository<BuddyRequest, Long> {
    Optional<BuddyRequest> findById(Long no);

    @Query(value="select * from buddy_request where user_id=:user and requested_id=:buddy ", nativeQuery=true)
    Optional<BuddyRequest> findByUserAndBuddyId(@Param("user") String userId, @Param("buddy")String requestedId);

    @Query(value="select user_id from buddy_request where requested_id=:user", nativeQuery=true)
    List<String> findByUserId(@Param("user")String userId);

    //@Query(value = "select * from table_name where case_1=:case_1 and date='2017-04-04' ", nativeQuery=true)
    //List<TableName> findSomeCase(@Param("case_1") String case_1);


}
