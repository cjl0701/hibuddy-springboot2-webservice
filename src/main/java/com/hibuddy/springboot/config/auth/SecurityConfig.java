package com.hibuddy.springboot.config.auth;

import com.hibuddy.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들을 활성화시켜 줌
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable().headers().frameOptions().disable() //ajax, h2-console 화면을 사용하기 위해 해당 옵션들을 disalbe함
                .and()
                .authorizeRequests() //URL별 권한 관리를 설정하는 옵션의 시작점
                  //antMatchers:권한 관리 대상을 지정하는 옵션
                .antMatchers("/", "/css/**", "/images/**", "/js/**").permitAll()//전체열람권한
                .antMatchers("/api/buddy/**").hasRole(Role.USER.name()) //USER 권한을 가진 사람만 열람 가능
                  //anyRequest:설정된 값들 이외 나머지 URL
                .anyRequest().authenticated() //나머지 URL들은 모두 인증된(로그인된) 사용자들에게만 허용
                .and()
                .logout() //로그아웃 기능에 대한 여러 설정의 진입점
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login() //로그인 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint() //로그인 성공 이후 사용자 정보를 가져올 때의 설정
                .userService(customOAuth2UserService);//소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체 등록

    }
}
