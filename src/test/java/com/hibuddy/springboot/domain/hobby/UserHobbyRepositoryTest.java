package com.hibuddy.springboot.domain.hobby;

import com.hibuddy.springboot.domain.user.*;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest //@SpringbootApplication 찾아 모든 빈 등록. application.properties를 읽고 mysql 사용
public class UserHobbyRepositoryTest {
    @Autowired
    UserHobbyRepository userHobbyRepository;
    @Autowired
    HobbyListRepository hobbyListRepository;
    @Autowired
    UserRepository userRepository;

    @After //Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정. 보통 여러 테스트를 수행할 때 다음 테스트 영향 주지 않기 위해
    public void cleanup() {
        userHobbyRepository.deleteById("testId");//user_hobby table에서 먼저 삭제해야 함!
        userRepository.deleteById("testId");
    }

    @Test
    public void 불러오기() {
        //given
        String userId = "by28";
        String hobby1 = "food";
        String hobby2 = "movie";
        String hobby3 = "music";

        //when
        List<UserHobby> uhList = userHobbyRepository.findAll();

        //then
        UserHobby userHobby = uhList.get(0);
        assertThat(userHobby.getUserId()).isEqualTo(userId);
        assertThat(userHobby.getHobby1()).isEqualTo(hobby1);
        assertThat(userHobby.getHobby2()).isEqualTo(hobby2);
        assertThat(userHobby.getHobby3()).isEqualTo(hobby3);
    }

    @Test
    public void 저장_불러오기() {
        //given
        String userId = "testId";
        String hobby = hobbyListRepository.findAll().get(0).getHobby();//animation

        userRepository.save(User.builder()
                .user_id(userId)
                .role(Role.GUEST)
                .build());

        userHobbyRepository.save(UserHobby.builder()
                .userId(userId)
                .hobby1(hobby)
                .build());

        //when
        List<UserHobby> uhList = userHobbyRepository.findAll();

        //then
        UserHobby userHobby = uhList.get(6);
        assertThat(userHobby.getUserId()).isEqualTo(userId);
        assertThat(userHobby.getHobby1()).isEqualTo(hobby);
    }

}
