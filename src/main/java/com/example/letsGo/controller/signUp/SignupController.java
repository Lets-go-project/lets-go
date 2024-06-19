package com.example.letsGo.controller.signUp;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    // 프로필 사진 기본 경로
    private static final String MAN_PROFILE_PICTURE = "/images/man.jpg";
    private static final String WOMAN_PROFILE_PICTURE = "/images/woman.jpg";

    @PostMapping("/signup")
    public String register(
                           @RequestParam("name") String name,
                           @RequestParam("gender") String gender,
                           @RequestParam("id") String id,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email,
                           @RequestParam("address") String address,
                           @RequestParam("year") int year,
                           @RequestParam("month") int month,
                           @RequestParam("day") int day,
                           @RequestParam(value = "profilepicture", required = false) String profilePicture,
                           Model model) {
        try {
            // 아이디 중복 확인
            User existingIdUser = userService.getUserById(id);
            if (existingIdUser != null) {
                model.addAttribute("error", "이미 사용 중인 아이디입니다.");
                System.out.println("이미 사용 중인 아이디입니다: " + id);
                return "signup/signup";
            }

            // 비밀번호 중복 확인
            User existingPasswordUser = userService.getUserByPassword(password);
            if (existingPasswordUser != null) {
                model.addAttribute("error", "이미 사용 중인 비밀번호입니다.");
                System.out.println("이미 사용 중인 비밀번호입니다: " + password);
                return "signup/signup";
            }

            // 이메일 중복 확인
            User existingEmailUser = userService.getUserByEmail(email);
            if (existingEmailUser != null) {
                model.addAttribute("error", "이미 사용 중인 이메일입니다.");
                System.out.println("이미 사용 중인 이메일입니다: " + email);
                return "signup/signup";
            }

            // 생년월일 유효성 검사
            if (!isValidDate(year, month, day)) {
                model.addAttribute("error", "올바른 생년월일을 입력하세요.");
                return "signup/signup";
            }

            // 생년월일을 Date 객체로 변환
            Date birthDate = parseDate(year, month, day);

            // User 객체 생성
            User user = User.builder()
                    .address(address)
                    .id(id)
                    .password(password)
                    .gender(gender)
                    .email(email)
                    .name(name)
                    .birth(birthDate)
                    .build();

            // 성별에 따라 프로필 사진 설정
            if ("여자".equals(gender)) {
                user.setProfilePicture(WOMAN_PROFILE_PICTURE);
            } else {
                user.setProfilePicture(MAN_PROFILE_PICTURE);
            }

            userService.saveUser(user);
            System.out.println(user.getUserId());
            // 회원가입 완료 후 리다이렉트할 페이지 설정
            return "redirect:/letsGo";
        } catch (Exception e) {
            // 예외 발생 시 콘솔에 출력
            e.printStackTrace();

            // 모델에 에러 메시지 추가
            model.addAttribute("error", "회원가입 중 오류가 발생했습니다.");

            // 에러가 발생한 경우 회원가입 페이지를 다시 표시
            return "signup/signup";
        }
    }

    // 생년월일 유효성 검사 메서드
    private boolean isValidDate(int year, int month, int day) {
        // 간단한 유효성 검사 예시
        if (year < 1900 || year > 2024 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }
        return true;
    }

    // 생년월일을 Date 객체로 변환하는 메서드
    private Date parseDate(int year, int month, int day) throws ParseException {
        String birthString = String.format("%d/%02d/%02d", year, month, day);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.parse(birthString);
    }
}