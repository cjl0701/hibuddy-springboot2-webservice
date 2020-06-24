package com.hibuddy.springboot.web;

import com.hibuddy.springboot.service.user.UserService;
import com.hibuddy.springboot.web.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController //json 형태로 반환
public class UserApiController {
    private final UserService userService;

    @GetMapping("/api/user/info/{userId}") //조회(R)
    public String confirmUserId(@PathVariable String userId){
        if(userService.confirmUserId(userId))
            return "exist";
        else
            return "available";
    }

    @PostMapping("/api/user/join") //생성(C)
    public String save(@RequestBody UserRequestDto requestDto){
        return userService.save(requestDto);
    }

    @PutMapping("/api/user/update/{userId}")//수정(U)
    public String update(@PathVariable String userId, @RequestBody UserRequestDto userRequestDto){
        return userService.update(userId, userRequestDto);
    }
}
