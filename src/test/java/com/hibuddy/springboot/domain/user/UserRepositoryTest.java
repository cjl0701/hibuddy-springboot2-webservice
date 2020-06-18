package com.hibuddy.springboot.domain.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest //슬라이스 테스트. H2 데이터베이스 사용
public class UserRepositoryTest {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserRepository userRepository;

    @Test
    public void di() throws SQLException{
        try(Connection connection = dataSource.getConnection()){
//            DatabaseMetaData metaData = connection.getMetaData();
//            System.out.println(metaData.getURL());
//            System.out.println(metaData.getDriverName());
//            System.out.println(metaData.getUserName());
            User user = new User();
            user.setUserId("cjl");
            user.setName("최재량");
            user.setRole(Role.USER);

            User newUser = userRepository.save(user);
            assertThat(newUser).isNotNull();
            Optional<User> existingUser = userRepository.findByUserId(newUser.getUserId());
            assertThat(existingUser).isNotNull();

            Optional<User> nonExistingUser = userRepository.findByUserId("non");
            assertThat(nonExistingUser).isNull();
        }
    }

}