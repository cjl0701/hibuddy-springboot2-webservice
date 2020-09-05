package com.hibuddy.springboot.web;

import com.hibuddy.springboot.service.user.UserService;
import com.hibuddy.springboot.web.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController //json 형태로 반환
public class UserApiController {
    private final UserService userService;

    //아이디 중복 확인
    @PostMapping("/api/user/info") //조회(R)
    public String confirmUserId(@RequestBody String userId){
        if(userService.confirmUserId(userId))
            return "exist";
        else
            return "available";
    }

    //회원 가입
    @PostMapping("/api/user/join") //생성(C)
    public String save(@RequestBody UserRequestDto requestDto){
        return userService.save(requestDto);
    }

    //회원 정보 수정
    @PutMapping("/api/user/update/{userId}")//수정(U)
    public String update(@PathVariable String userId, @RequestBody UserRequestDto userRequestDto){
        return userService.update(userId, userRequestDto);
    }
}
