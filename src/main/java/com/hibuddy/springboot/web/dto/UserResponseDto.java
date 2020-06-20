package com.hibuddy.springboot.web.dto;

import com.hibuddy.springboot.domain.user.Role;
import com.hibuddy.springboot.domain.user.User;
import com.hibuddy.springboot.domain.user.UserHobby;
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
    private int age;
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
        this.age = entity.getAge();
        this.email = entity.getEmail();
        this.phone = entity.getPhone();
        this.nation = entity.getNation();
        this.nativeLanguage = entity.getNativeLanguage();
        this.secondLanguage = entity.getSecondLanguage();
        this.role = entity.getRole();
    }

    public  UserResponseDto(UserHobby hobbyEntity){
        this.hobby1=hobbyEntity.getHobby1();
        this.hobby1=hobbyEntity.getHobby2();
        this.hobby1=hobbyEntity.getHobby3();
    }

    @Builder// 생성자 대신 사용, 어느 필드에 어떤 값을 채워야 하는지 명확하게 인지 가능. builder().title(title) 이런 식
    public UserResponseDto(String userId, String name, String sex, int age, String nation,
                           String nativeLanguage, String secondLanguage, String phone, String email,
                           Role role, String hobby1, String hobby2, String hobby3) {
        this.userId = userId;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.nation = nation;
        this.nativeLanguage = nativeLanguage;
        this.secondLanguage = secondLanguage;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.hobby1 = hobby1;
        this.hobby2 = hobby2;
        this.hobby3 = hobby3;
    }
}