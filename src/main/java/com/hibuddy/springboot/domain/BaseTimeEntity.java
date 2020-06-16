//package com.hibuddy.springboot.domain;
//
//import lombok.Getter;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import javax.persistence.EntityListeners;
//import javax.persistence.MappedSuperclass;
//import java.time.LocalDateTime;
//
//@Getter
//@MappedSuperclass //JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 아래 필드들도 칼럼으로 인식하도록 함
//@EntityListeners(AuditingEntityListener.class) //이 클래스에 Auditing 기능 포함시킴.
//public abstract class BaseTimeEntity { //모든 Entity의 상위 클래스가 되어 Entity들의 생성날짜, 수정날짜를 자동으로 관리.
//    @CreatedDate //Entity가 생성되어 저장될 때 시간이 자동 저장됨.
//    private LocalDateTime createdDate;
//
//    @LastModifiedDate
//    private LocalDateTime modifiedDate;
//}