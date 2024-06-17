package com.example.letsGo.controller.user;

import com.example.letsGo.domain.member.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user-profile")
    public String userProfile(Model model) {
//        User user = new User();
//        user.setProfilePicture("path/to/profile-picture.jpg"); // 프로필 이미지 경로 설정

        User user = User.builder()
                .profilePicture("path/to/profile-picture.jpg") // 프로필 이미지 경로 설정
                .build();

        model.addAttribute("user", user);
        return "user-profile"; // 사용자 프로필 페이지 템플릿 이름
    }
}
