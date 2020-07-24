package com.hibuddy.springboot.web;

import com.hibuddy.springboot.config.auth.LoginUser;
import com.hibuddy.springboot.config.auth.dto.SessionUser;
import com.hibuddy.springboot.domain.hobby.HobbyList;
import com.hibuddy.springboot.domain.hobby.HobbyListRepository;
import com.hibuddy.springboot.domain.user.Role;
import com.hibuddy.springboot.domain.user.UserRepository;
import com.hibuddy.springboot.service.buddy.BuddyService;
import com.hibuddy.springboot.service.hobby.HobbyListService;
import com.hibuddy.springboot.service.user.UserService;
import com.hibuddy.springboot.web.dto.SameHobbyBuddyDto;
import com.hibuddy.springboot.web.dto.UserRequestDto;
import com.hibuddy.springboot.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @Autowired
    private final UserService userService;//C->S->R
    @Autowired
    private final HobbyListService hobbyListService;
    @Autowired
    private final BuddyService buddyService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser sessionUser) { //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장.
        //index.mustache에서 userName을 사용할 수 있게 model에 저장
        if (sessionUser != null) {
            model.addAttribute("user", sessionUser);
            if (sessionUser.getRole().equals(Role.GUEST))
                model.addAttribute("guest", "guest");
        }
        return "index"; //머스테치 스타터->~/templates/index.mustache로 전환해줌
    }

    @GetMapping("/user/join")
    public String userJoin(Model model, @LoginUser SessionUser sessionUser) {
        model.addAttribute("user", sessionUser);
        model.addAttribute("hobbyList", hobbyListService.findAll());
        return "user-join";
    }

    @GetMapping("/user/update")
    public String userUpdate(Model model, @LoginUser SessionUser sessionUser) {
        UserResponseDto userResponseDto = userService.findTotalInfo(sessionUser.getUserId());
        model.addAttribute("user", userResponseDto);
        model.addAttribute("hobbyList", hobbyListService.findAll());
        return "user-update";
    }

    @GetMapping("/buddy/make")
    public String findBuddyByHobby(Model model, @LoginUser SessionUser sessionUser) {
        model.addAttribute("user", sessionUser);
        model.addAttribute("buddies", userService.findByHobby(sessionUser.getUserId()));
        return "find-buddy";
    }

    @GetMapping("/buddy/list")
    public String buddyList(Model model, @LoginUser SessionUser sessionUser) {
        model.addAttribute("user", sessionUser);
        model.addAttribute("buddies", buddyService.findBuddies(sessionUser.getUserId()));
        model.addAttribute("requests", buddyService.findRequests(sessionUser.getUserId()));
        return "buddy-list";
    }
    /*
    GetMapping과 같이 Controller에서 URL 매핑을 담당하는 어노테이션에 명확하게 주소가 없으면
    Controller에 매핑되지 않는 요청은 모두 해당 메소드로 간다.
    index.js 요청 역시 Controller가 매핑된 요청이 아니니 자연스레 여기로 요청이 옴..
     */


}

