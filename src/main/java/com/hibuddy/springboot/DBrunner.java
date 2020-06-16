//package com.hibuddy.springboot;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.Statement;
//
//@Component
//public class DBrunner implements ApplicationRunner {
//
//    @Autowired
//    DataSource dataSource; //DB 연결과 관련된 정보를 가지고 있음
//
//    @Autowired
//    JdbcTemplate jdbcTemplate; //드라이버 로딩, DB 연결, 자원 해제 다 해줌. sql만 날리고 나머지는 스프링 프레임워크에게 맡기자!
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        try (Connection connection = dataSource.getConnection()) {
//            System.out.println(dataSource.getClass());//DBCP 뭐 쓰는지(default: hikari)
//            System.out.println(connection.getMetaData().getURL());
//            System.out.println(connection.getMetaData().getUserName());
//
//            Statement statement = connection.createStatement();
//            //String sql = "USE hibuddy;";
//            //statement.executeUpdate(sql);
//        }
//        //int no = 3;
//        //Double grade = jdbcTemplate.queryForObject("SELECT s_grade FROM STUDENT WHERE s_no=?;", Double.class, no);
//        //System.out.println(no + "의 성적= " + grade);
//        String name = jdbcTemplate.queryForObject("select name from user where user_id=?;",String.class , "by28");
//        System.out.println(name);
//        //jdbcTemplate.execute("INSERT INTO USER VALUES(1,'CJL')");
//    }
//}
//
