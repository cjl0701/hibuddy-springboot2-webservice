package com.hibuddy.springboot.domain.buddy;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Posts 클래스로 Database를 접근하게 해줄 JpaRepository
// 보통 Dao라고 불리는 DB Layer 접근자. (JPA에선 Repository라고 부름)
// JpaRepository<Entity 클래스, PK타입>를 상속하면 기본적인 CRUD 메소드가 자동 생성됨
public interface BuddyListRepository  extends JpaRepository<BuddyList, Long> {
    List<BuddyList> findAllByUserId(String userId);
    List<BuddyList> findAllByBuddyId(String userId);
}
