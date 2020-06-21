package com.hibuddy.springboot.web;

import com.hibuddy.springboot.config.auth.LoginUser;
import com.hibuddy.springboot.config.auth.dto.SessionUser;
import com.hibuddy.springboot.domain.buddy.BuddyRequest;
import com.hibuddy.springboot.service.buddy.BuddyService;
import com.hibuddy.springboot.service.user.UserService;
import com.hibuddy.springboot.web.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController //json 형태로 반환
public class BuddyApiController {
    private final UserService userService;
    private final BuddyService buddyService;

    @PostMapping("/api/buddy/request")
    public String buddyRequest(@RequestBody String buddyId, @LoginUser SessionUser sessionUser) {
        return buddyService.save(sessionUser.getUserId(), buddyId);
    }

    @PostMapping("/api/buddy/accept")
    public String buddyAccept(@RequestBody String buddyId, @LoginUser SessionUser sessionUser) {
        return buddyService.accept(sessionUser.getUserId(), buddyId);
    }
}
