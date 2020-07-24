//package com.hibuddy.springboot.domain.buddy;
//
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//
////JPA Auditing 테스트
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class BuddyRequestRepositoryTest {
//    @Autowired
//    BuddyRequestRepository buddyRequestRepository;
//
//    /*@After //Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정. 보통 여러 테스트를 수행할 때 다음 테스트 영향 주지 않기 위해
//    public void cleanup() {
//        buddyRequestRepository.deleteAll();
//    }*/
//
//    @Test
//    public void BaseTimeEntity_등록() {
//        //given
//        LocalDateTime now = LocalDateTime.of(2020, 6, 16, 23, 30, 0);
//        buddyRequestRepository.save(BuddyRequest.builder()
//                .userId("by28")
//                .requestedId("momo")
//                .build());
//
//        //when
//        List<BuddyRequest> reqList = buddyRequestRepository.findAll();
//
//        //then
//        BuddyRequest req = reqList.get(0);
//
//        System.out.println(">>>>>>> createDate" + req.getCreatedDate());
//        assertThat(req.getCreatedDate()).isAfter(now);
//    }
//}