package com.hibuddy.springboot.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class UserContact {
    @Id
    private String userId;
    @Column
    private String phone;
    @Column
    private String email;
    @Builder// 생성자 대신 사용, 어느 필드에 어떤 값을 채워야 하는지 명확하게 인지 가능. builder().title(title) 이런 식
    public UserContact(String userId, String phone, String email){
        this.userId=userId;
        this.phone=phone;
        this.email=email;
    }
}
