package com.example.letsGo.controller.myPage;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/mypage")
public class MypageController {
    private final UserService userService;

    public MypageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getMyPage(HttpSession session, Model model) {
        // 세션에서 사용자 정보 가져오기
        User user = (User) session.getAttribute("user");

        // 사용자 정보를 모델에 추가
        if (user != null) {
            model.addAttribute("user", user);
        } else {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉션
            return "redirect:/signin";
        }

        return "mypage/mypage";
    }

    @GetMapping("/memberinfo")
    public String getMemberInfo(HttpSession session, Model model) {
        // 세션에서 사용자 정보 가져오기
        User user = (User) session.getAttribute("user");

        // 사용자 정보를 모델에 추가
        if (user != null) {
            model.addAttribute("user", user);
            return "mypage/memberinfo";
        } else {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉션
            return "redirect:/signin";
        }
    }


    @PostMapping("/update")
    public String updateUserInfo(HttpSession session,
                                 @RequestParam("name") String name,
                                 @RequestParam("address") String address,
                                 RedirectAttributes redirectAttributes) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            // 사용자 정보 업데이트
            user.setName(name);
            user.setAddress(address);
            userService.updateUser(user);
            return "redirect:/mypage/memberinfo";
        } else {
            return "redirect:/signin";
        }
    }

    @GetMapping("/poolscrap")
    public String getPoolScrap(HttpSession session, Model model) {
        // 세션에서 사용자 정보 가져오기
        User user = (User) session.getAttribute("user");

        // 사용자 정보를 모델에 추가
        if (user != null) {
            model.addAttribute("user", user);
            return "mypage/poolscrap";
        } else {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉션
            return "redirect:/signin";
        }
    }

    @GetMapping("/postscrap")
    public String getPostScrap(HttpSession session, Model model) {
        // 세션에서 사용자 정보 가져오기
        User user = (User) session.getAttribute("user");

        // 사용자 정보를 모델에 추가
        if (user != null) {
            model.addAttribute("user", user);
            return "mypage/postscrap";
        } else {
            // 사용자 정보가 없는 경우 로그인 페이지로 리디렉션
            return "redirect:/signin";
        }
    }
}