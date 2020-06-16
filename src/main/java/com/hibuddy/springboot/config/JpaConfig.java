package com.hibuddy.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@WebMvcTest는 @Configuration은 스캔하지 않아
@Configuration
@EnableJpaAuditing // JPA Auditing 활성화
public class JpaConfig {
}
