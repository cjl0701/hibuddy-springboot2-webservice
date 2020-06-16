package com.hibuddy.springboot.domain.user;
//각 사용자의 권한을 관리할 Enum 클래스

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUEST", "guest"),
    USER("ROLE_USER","user"); // Enum을 사용하여 "USER", "ROLE_USER", "일반 사용자"를 한 묶음으로 만듦!

    private final String key;
    private final String title;
}

