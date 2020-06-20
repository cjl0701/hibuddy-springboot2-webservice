package com.hibuddy.springboot.domain.user;

import com.hibuddy.springboot.web.dto.UserResponseDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryCustomTest {

    @Autowired
    private UserRepository userRepository;

    private String userId;

//    @After
//    public void tearDown() throws Exception{
//        userRepository.deleteByUserId(userId);
//    }

    @Test
    public void querydsl_Custom설정_기능_확인(){
        //given
        userId="test";
        String name="테스트이름";
        Role role = Role.USER;
        userRepository.save(User.builder()
                .userId(userId)
                .role(role)
                .name(name)
                .build());

        //when
        List<User> result = userRepository.findByUserIdToList(userId);

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getName(),is(name));
    }
    @Test
    public void 관계없을때_조인_맺기() {
        //given
        userId = "by28";
        int age = 28;
        String hobby1 = "food";
        String hobby2 = "movie";
        String hobby3 = "music";

        //when
        List<UserResponseDto> userResponseDto = userRepository.findTotalInfo(userId);

        //then
        assertThat(userResponseDto.size(), is(1));
        assertThat(userResponseDto.get(0).getUserId(), is(userId));
        assertThat(userResponseDto.get(0).getAge(), is(age));
        assertThat(userResponseDto.get(0).getHobby1(), is(hobby1));
        assertThat(userResponseDto.get(0).getHobby2(), is(hobby2));
        assertThat(userResponseDto.get(0).getHobby3(), is(hobby3));
    }
}