//package com.hibuddy.springboot.domain.user;
//
//
//import org.junit.After;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.assertThat;
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserRepositorySupportTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserRepositorySupport userRepositorySupport;
//
//    private String userId="test";
//    @After
//    public void tearDown() throws Exception{
//        userRepository.deleteByUserId(userId);
//    }
//    @Test
//    public void querydsl_기본_기능_확인(){
//        //given
//        String name="테스트이름";
//        Role role = Role.USER;
//        userRepository.save(User.builder()
//                .userId(userId)
//                .role(role)
//                .name(name)
//                .build());
//
//        //when
//        List<User> result = userRepositorySupport.findByUserId(userId);
//
//        //then
//        assertThat(result.size(), is(1));
//        assertThat(result.get(0).getName(),is(name));
//    }
//}