package com.hibuddy.springboot.web.dto;

import com.hibuddy.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class UserResponseDto {
    private String userId;
    private String name;
    private String email;


    //Entity의 필드 중 일부만 사용하므로 생성자로 Entity를 받아 값을 넣음
    public UserResponseDto(User entity){
        this.userId=entity.getUserId();
        this.email=entity.getEmail();
        this.name=entity.getName();
    }
    @Builder
    public UserResponseDto(String userId){
        this.userId=userId;
    }
}