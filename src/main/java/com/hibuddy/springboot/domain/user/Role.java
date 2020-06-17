package com.hibuddy.springboot.domain.user;
//각 사용자의 권한을 관리할 Enum 클래스

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "guest"), //스프링 시큐리티에서는 권한 코드에 항상 ROLE_이 앞에 있어야만 함
    USER("ROLE_USER","user"); // Enum을 사용하여 "USER", "ROLE_USER", "일반 사용자"를 한 묶음으로 만듦!

    private final String key;
    private final String title;
}

