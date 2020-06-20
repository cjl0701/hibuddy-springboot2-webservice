package com.hibuddy.springboot.web.dto;

import com.hibuddy.springboot.domain.user.Role;
import com.hibuddy.springboot.domain.user.User;
import com.hibuddy.springboot.domain.user.UserHobby;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class SameHobbyBuddyDto {
    private String userId;
    private String sex;
    private int age;
    private String nation;
    private String nativeLanguage;
    private String secondLanguage;
    private String hobby1;
    private String hobby2;
    private String hobby3;

    @Builder// 생성자 대신 사용, 어느 필드에 어떤 값을 채워야 하는지 명확하게 인지 가능. builder().title(title) 이런 식
    public SameHobbyBuddyDto(String userId, String sex, int age, String nation,
                           String nativeLanguage, String secondLanguage,
                           String hobby1, String hobby2, String hobby3) {
        this.userId = userId;
        this.sex = sex;
        this.age = age;
        this.nation = nation;
        this.nativeLanguage = nativeLanguage;
        this.secondLanguage = secondLanguage;
        this.hobby1 = hobby1;
        this.hobby2 = hobby2;
        this.hobby3 = hobby3;
    }
}