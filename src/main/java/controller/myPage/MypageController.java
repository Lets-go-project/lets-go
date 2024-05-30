package controller.myPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
public class MypageController {

    @GetMapping("/mypage")
    public String getMyPage() {
        return "mypage/mypage";
    }
    @GetMapping("/memberinfo")
    public String getMemberInfo() {
        return "mypage/memberinfo";
    }
    @GetMapping("/poolscrap")
    public String getPoolScrap() {
        return "mypage/poolscrap";
    }
    @GetMapping("/postscrap")
    public String getPostScrap() {
        return "mypage/postscrap";
    }
}
