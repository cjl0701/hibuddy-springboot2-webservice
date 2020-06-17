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
    private String phone;
    @Column
    private String email;

    @Enumerated(EnumType.STRING) //JPA로 DB에 저장할 때 Enum 값을 문자열로 저장할 수 있도록 선언.(의미를 파악하기 위해)
    @Column(nullable = false)
    private Role role;

    @Builder// 생성자 대신 사용, 어느 필드에 어떤 값을 채워야 하는지 명확하게 인지 가능. builder().title(title) 이런 식
    public User(String userId, String name, String sex, int age, String nation,
                String nativeLanguage, String secondLanguage, String phone, String email, Role role) {
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
    }

    //for JPA의 영속성 컨텍스트. 트랜잭션 과정에서 DB에서 데이터를 가져오면, 트랙잭션이 끝나는 시점에 해당 테이블에 변경분을 반영
    //즉, Entity 객체의 값만 변경하면 별로도 Update 쿼리를 날리지 않아도 알아서 해줌.
    public User update(String name) {
        this.name = name;


        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
