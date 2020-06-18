package com.hibuddy.springboot.web;

import com.hibuddy.springboot.service.user.UserService;
import com.hibuddy.springboot.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


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
//    public PostsResponseDto findById(@PathVariable Long id){
//        return postsService.findById(id);
//    }

//    @PostMapping("/api/user/info/{userId}") //생성(C)
//    public Long save(@RequestBody PostsSaveRequestDto requestDto){
//        // @RequestBody, @ResponseBody 어노테이션을 사용하면 컨트롤러에서 JSON 데이터를 주고받을 수 있다.
//        return postsService.save(requestDto);
//    }
//
//    @PutMapping("/api/v1/posts/{id}") //수정(U)
//    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
//        return postsService.update(id, requestDto);
//    }
//
//    @DeleteMapping("/api/v1/posts/{id}") //삭제(D)
//    public Long delete(@PathVariable Long id){
//        postsService.delete(id);
//        return id;
//    }

}
