package com.hibuddy.springboot.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//사용자 정보를 담당할 도메인
@Setter
@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    private String userId;
    @Column
    private String name;
    @Column
    private String sex;
    @Column
    private int age;
    @Column
    private String nation;
    @Column
    private String nativeLanguage;
    @Column
    private String secondLanguage;
    @Column
    private String picture;

    @Enumerated(EnumType.STRING) //JPA로 DB에 저장할 때 Enum 값을 문자열로 저장할 수 있도록 선언.(의미를 파악하기 위해)
    @Column(nullable = false)
    private Role role;

    @Builder// 생성자 대신 사용, 어느 필드에 어떤 값을 채워야 하는지 명확하게 인지 가능. builder().title(title) 이런 식
    public User(String user_id, String name, String sex, int age, String nation,
                String native_language, String second_language, String picture, Role role){
       this.userId=user_id;
       this.name=name;
       this.sex=sex;
       this.age=age;
       this.nation=nation;
       this.nativeLanguage=native_language;
       this.secondLanguage=second_language;
       this.picture=picture;
       this.role=role;
    }

}
