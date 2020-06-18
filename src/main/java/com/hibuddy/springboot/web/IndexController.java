package com.hibuddy.springboot.web;

import com.hibuddy.springboot.config.auth.LoginUser;
import com.hibuddy.springboot.config.auth.dto.SessionUser;
import com.hibuddy.springboot.domain.hobby.HobbyList;
import com.hibuddy.springboot.domain.hobby.HobbyListRepository;
import com.hibuddy.springboot.domain.user.Role;
import com.hibuddy.springboot.domain.user.UserRepository;
import com.hibuddy.springboot.service.hobby.HobbyListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final HobbyListService hobbyListService;  //C->S->R

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){ //Model: 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장.
        //postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달
        //model.addAttribute("posts",postsService.findAllDesc());

        //CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구성했었음.
        //(before)SessionUser user = (SessionUser)httpSession.getAttribute("user");

        //index.mustache에서 userName을 사용할 수 있게 model에 저장
        if(user!=null) {
            model.addAttribute("user", user);
            if(user.getRole().equals(Role.GUEST))
                model.addAttribute("guest", "guest");
        }
        return "index"; //머스테치 스타터->~/templates/index.mustache로 전환해줌
    }

    @GetMapping("/user/join")
    public String userJoin(Model model, @LoginUser SessionUser user){
        model.addAttribute("user", user);
        model.addAttribute("hobbyList", hobbyListService.findAll());
        return "user-join";
    }

    @GetMapping("/user/update/{email}")
    public String userUpdate(){
        return "user-update";
    }
    /*
    GetMapping과 같이 Controller에서 URL 매핑을 담당하는 어노테이션에 명확하게 주소가 없으면
    Controller에 매핑되지 않는 요청은 모두 해당 메소드로 간다.
    index.js 요청 역시 Controller가 매핑된 요청이 아니니 자연스레 여기로 요청이 옴..
     */

//    @GetMapping("/posts/update/{id}")
//    public String postsUpdate(@PathVariable Long id, Model model) {
//        PostsResponseDto dto = postsService.findById(id);
//        model.addAttribute("post", dto);
//
//        return "posts-update";
//    }


}

