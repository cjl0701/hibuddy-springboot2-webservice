package com.hibuddy.springboot.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
public class UserHobby {
    @Id
    private String userId;
    @Column(nullable = true)
    private String hobby1;
    @Column(nullable = true)
    private String hobby2;
    @Column(nullable = true)
    private String hobby3;

    @Builder// 생성자 대신 사용, 어느 필드에 어떤 값을 채워야 하는지 명확하게 인지 가능. builder().title(title) 이런 식
    public UserHobby(String userId, String hobby1, String hobby2, String hobby3) {
        this.userId = userId;
        this.hobby1 = hobby1;
        this.hobby2 = hobby2;
        this.hobby3 = hobby3;
    }
}