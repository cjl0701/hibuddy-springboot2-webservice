package com.hibuddy.springboot.web.dto;

import com.hibuddy.springboot.domain.user.Role;
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
    private String phone;
    private String sex;
    private String age;
    private String nation;
    private String nativeLanguage;
    private String secondLanguage;
    private Role role;
    private String hobby1;
    private String hobby2;
    private String hobby3;

    public UserResponseDto(User entity) {
        this.userId = entity.getUserId();
        this.name = entity.getName();
        this.sex = entity.getSex();
        this.age = String.valueOf(entity.getAge());
        this.email = entity.getEmail();
        this.phone = entity.getPhone();
        this.nation = entity.getNation();
        this.nativeLanguage = entity.getNativeLanguage();
        this.secondLanguage = entity.getSecondLanguage();
        this.role = entity.getRole();
    }
//    @Builder
//    public UserResponseDto(String userId, String email, String sex, String age, String phone, String nation,
//                           String nativeLanguage, String secondLanguage, String hobby1, String hobby2, String hobby3) {
//        this.userId = userId;
//        this.email = email;
//        this.sex = sex;
//        this.age = age;
//        this.phone = phone;
//        this.nation = nation;
//        this.nativeLanguage = nativeLanguage;
//        this.secondLanguage = secondLanguage;
//    }
}