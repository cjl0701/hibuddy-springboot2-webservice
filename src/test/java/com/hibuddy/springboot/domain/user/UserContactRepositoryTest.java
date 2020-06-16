package com.hibuddy.springboot.domain.user;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest //@SpringbootApplication 찾아 모든 빈 등록. application.properties를 읽고 mysql 사용
public class UserContactRepositoryTest {
    private String userId = "testId2";
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserContactRepository userContactRepository;

    @After //Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정. 보통 여러 테스트를 수행할 때 다음 테스트 영향 주지 않기 위해
    public void cleanup() {
        userRepository.deleteById(userId);
        userContactRepository.deleteById(userId);
    }

    @Test
    public void 불러오기() {
        //given
        String userId = "by28";
        String email = "by28@naver.com";

        //when
        List<UserContact> ucList = userContactRepository.findAll(); //테이블 UserContactRepository에 있는 모든 데이터 조회

        //then
        UserContact userContact = ucList.get(0);
        assertThat(userContact.getUserId()).isEqualTo(userId);
        assertThat(userContact.getEmail()).isEqualTo(email);
    }

    @Test
    public void 저장_불러오기() {
        //given
        userRepository.save(User.builder() //테이블 posts에 insert 나 update 쿼리 실행
                .user_id(userId)
                .role(Role.GUEST)
                .build());

        userContactRepository.save(UserContact.builder() //테이블 posts에 insert 나 update 쿼리 실행
                .userId(userId)
                .phone("01022223333")
                .email("cjl2076@naver.com")
                .build());

        //when
        List<UserContact> ucList = userContactRepository.findAll(); //테이블 UserContactRepository에 있는 모든 데이터 조회

        //then
        UserContact userContact = ucList.get(6);
        assertThat(userContact.getUserId()).isEqualTo(userId);
        assertThat(userContact.getEmail()).isEqualTo("cjl2076@naver.com");
    }

}
