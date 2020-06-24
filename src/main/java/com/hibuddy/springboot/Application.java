package com.hibuddy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication // 자동 설정, 빈 읽기와 생성 자동화. 아래 것들 +a 포함!
//@SpringBootConfiguration // == @Configuration: 스프링 설정 파일(스프링 컨테이너 생성)
//@ComponentScan // @Component를 가진 클래스들을 스캔해서 전부 빈으로 등록
//@EnableAutoConfiguration // 스프링 메타 파일에서 조건에 맞게 자바 설정 파일들 읽어옴(@Configuration), 웹 관련 설정
public class Application { // 프로젝트의 메인 클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS 실행
    }
}