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
    //for JPA의 영속성 컨텍스트. 트랜잭션 과정에서 DB에서 데이터를 가져오면, 트랙잭션이 끝나는 시점에 해당 테이블에 변경분을 반영
    //즉, Entity 객체의 값만 변경하면 별로도 Update 쿼리를 날리지 않아도 알아서 해줌.
    public UserHobby update(UserHobby entity) {
        this.hobby1=entity.hobby1;
        this.hobby2=entity.hobby2;
        this.hobby3=entity.hobby3;
        return this;
    }
}