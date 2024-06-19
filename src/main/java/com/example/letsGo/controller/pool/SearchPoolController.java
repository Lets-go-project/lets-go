package com.example.letsGo.controller.pool;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SearchPoolController {

    @PostMapping("/swimpool/makeQuery")
    @ResponseBody
    public Map<String, String> searchPool(@RequestParam("area1") String area1, HttpServletRequest request) {
        // 검색어를 세션에 저장
        HttpSession session = request.getSession();
        session.setAttribute("searchQuery", area1);

        // JSON 형태로 응답
        Map<String, String> response = new HashMap<>();
        response.put("searchQuery", area1);
        return response;
    }

}