package com.example.letsGo.controller.record;

import com.example.letsGo.domain.member.User;
import com.example.letsGo.domain.record.Record;
import com.example.letsGo.service.RecordService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/record")
public class RecordController {
    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/view")
    public String getRecord(int recordId) {
        recordService.getRecord(recordId);
        return "/record/viewRecord";
    }

    @GetMapping("/all")
    public String getAllRecords(HttpSession session, Model model) {
        log.info("-----들어엄");

        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();

        List<Record> records = recordService.getAllRecords(userId);

        log.info("-----edfef");

        model.addAttribute("records", records);

        return "record/viewRecord";
    }

    @PostMapping("/add")
    public String addRecord(Record rec) {
        recordService.addRecord(rec);
        return "redirect:/record/add";
    }

    @PostMapping("/update")
    public String updateRecord(int recordId, Record rec) {
        recordService.updateRecord(recordId, rec);
        return "redirect:/record/update";
    }

    @DeleteMapping("/delete")
    public String deleteRecord(int recordId) {
        recordService.deleteRecord(recordId);
        return "redirect:/record/delete";
    }
}
