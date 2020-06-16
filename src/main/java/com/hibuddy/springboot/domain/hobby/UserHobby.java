package com.hibuddy.springboot.domain.hobby;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class UserHobby {
    @Id
    private String userId;
    @Id
    private String hobbyName;

    @Builder// 생성자 대신 사용, 어느 필드에 어떤 값을 채워야 하는지 명확하게 인지 가능. builder().title(title) 이런 식
    public UserHobby(String userId, String hobbyName){
        this.userId=userId;
        this.hobbyName=hobbyName;
    }
}