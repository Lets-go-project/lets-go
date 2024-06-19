package com.example.letsGo.controller.record;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.record.Record;
import com.example.letsGo.repository.RecordRepository;
import com.example.letsGo.repository.UserRepository;
import com.example.letsGo.service.RecordService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/record")
public class RecordController {
    private final RecordService recordService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecordRepository recordRepository;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }


    @GetMapping("/all")
    public String getAllRecords(HttpSession session, Model model) {
        log.info("-----들어엄");

        User user = (User) session.getAttribute("user");
        if (user == null) {
            log.error("로그인이 필요합니다.");
            return "redirect:/signin/signin";
        }

//        int userId = user.getUserId();
        int userId = 1;

        List<Record> records = recordService.getAllRecords(userId);

        log.info("-----edfef");

        model.addAttribute("records", records);

        log.info("[view] User Id: {}", userId);
        log.info("[view] Records: {}", records);

        return "redirect:/record/view";
    }

    @GetMapping("/view")
    public String moveViewRecords(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/signin/signin";
        }
        log.info("[moveView] user ID: {}", user.getId());

//        int userId = user.getUserId();
        int userId = 1;

//        String filter = (String)model.getAttribute("filter");
//        log.info("[moveView] filter: {}", filter);
//
//        if (Objects.equals(filter, "date")) {
//            List<Record> records = recordRepository.findByUserIdOrderBySwimDateDesc(userId);
//            model.addAttribute("records", records);
//        } else if (Objects.equals(filter, "time")) {
//            List<Record> records = recordRepository.findByUserIdOrderBySwimTimeDesc(userId);
//            model.addAttribute("records", records);
//        } else if (Objects.equals(filter, "dist")) {
//            List<Record> records = recordRepository.findByUserIdOrderBySwimDistDesc(userId);
//            model.addAttribute("records", records);
//        } else {
//            List<Record> records = recordRepository.findByUserId(userId);
//            model.addAttribute("records", records);
//        }

        List<Record> records = recordRepository.findByUserId(userId);
        model.addAttribute("records", records);

        log.info("[moveView] Records: {}", records);
        log.info("[moveView] record: {}", records.toString());
        return "record/viewRecord";
    }
    @GetMapping("/moveAdd")
    public String moveAdd(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/signin/signin";
        }

        log.info("[moveAdd] user ID: {}", user.getId());

        return "record/addRecord";
    }

    @PostMapping("/add")
    public String addRecord(HttpSession session,
                            @RequestParam("swimDate") String swimDate,
                            @RequestParam("swimName") String swimName,
                            @RequestParam("swimTime") float swimTime,
                            @RequestParam("swimDist") float swimDist) {

        User user = (User) session.getAttribute("user");
        log.info("[add] user Id: {}", user.getId());

        System.out.println(swimDate);
        System.out.println(swimName);
        System.out.println(swimTime);
        System.out.println(swimDist);

        Record record = Record.builder()
                .swimDate(swimDate)
                .swimName(swimName)
                .swimTime(swimTime)
                .swimDist(swimDist)
//                .userId(user.getUserId())
                .userId(1)
                .id(user.getId())
                .gender(user.getGender())
                .build();


        recordRepository.save(record);
        log.info("record: {}", record);
        return "redirect:/record/all";
    }

    @GetMapping("/moveUpdate")
    public String showUpdateForm(HttpSession session) { //기록 수정 페이지로 이동
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/signin/signin";
        }

        log.info("[moveUpdate] user ID: {}", user.getId());
        return "record/updateRecord";
    }

    @PostMapping("/update/{recordId}")
    public String updateRecord(@PathVariable Long recordId, @ModelAttribute Record rec, Model model) {
        recordService.updateRecord(recordId, rec);
        model.addAttribute("record", rec);
        return "redirect:/record/all";
    }

    @GetMapping("/delete/{recordId}")
    public String deleteRecord(@PathVariable Long recordId) {
        recordService.deleteRecord(recordId);
        return "redirect:/record/all"; // 기록 삭제 후 전체 기록 페이지로 리다이렉트
    }
}
