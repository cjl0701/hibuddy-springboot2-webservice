package com.hibuddy.springboot.web.dto;

import com.hibuddy.springboot.domain.user.UserHobby;
import com.hibuddy.springboot.domain.user.Role;
import com.hibuddy.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//Controller와 Service에서 사용할 Dto 클래스
@Getter
@NoArgsConstructor
public class UserRequestDto {
    private String userId;
    private String name;
    private String email;
    private String sex;
    private String age;
    private String phone;
    private String nation;
    private String nativeLanguage;
    private String secondLanguage;
    private String hobby1;
    private String hobby2;
    private String hobby3;

    @Builder
    public UserRequestDto(String userId, String name, String email, String sex, String age, String phone, String nation,
                          String nativeLanguage, String secondLanguage, String hobby1, String hobby2, String hobby3) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.nation = nation;
        this.nativeLanguage = nativeLanguage;
        this.secondLanguage = secondLanguage;
        this.hobby1 = hobby1;
        this.hobby2 = hobby2;
        this.hobby3 = hobby3;
    }

    public User toUserEntity() {
        return User.builder()
                .userId(userId)
                .name(name)
                .email(email)
                .sex(sex)
                .age(Integer.parseInt(age))
                .phone(phone)
                .nation(nation)
                .nativeLanguage(nativeLanguage)
                .secondLanguage(secondLanguage)
                .role(Role.USER)
                .build();
    }

    public UserHobby toHobbyEntity() {
        return UserHobby.builder()
                .userId(userId)
                .hobby1(hobby1)
                .hobby2(hobby2)
                .hobby3(hobby3)
                .build();
    }
}
