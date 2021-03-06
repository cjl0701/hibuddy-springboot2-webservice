package com.hibuddy.springboot.config.auth.dto;

import com.hibuddy.springboot.domain.user.Role;
import com.hibuddy.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

//세션에 사용자 정보를 저장하기 위한 Dto 클래스
//SessionUser에는 인증된 사용자 정보만 필요
@Getter
public class SessionUser implements Serializable {//직렬화 기능
    private String name;
    private String email;
    private Role role;
    private String userId;
    //private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole();
        this.userId=user.getUserId().isEmpty()?user.getName():user.getUserId();
        //this.picture=user.getPicture();
    }

}
