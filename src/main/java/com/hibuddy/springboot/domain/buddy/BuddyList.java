package com.hibuddy.springboot.domain.buddy;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class BuddyList {
    @Id // 해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙. GenerationType.IDENTITY 옵션-> auto_increment
    private Long no;
    @Column
    private String userId;
    @Column
    private String buddyId;

    @Builder// 생성자 대신 사용, 어느 필드에 어떤 값을 채워야 하는지 명확하게 인지 가능. builder().title(title) 이런 식
    public BuddyList(String userId, String buddyId) {
        this.userId = userId;
        this.buddyId = buddyId;
    }
}