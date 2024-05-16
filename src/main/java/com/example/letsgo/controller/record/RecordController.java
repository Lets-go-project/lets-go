package com.example.letsgo.controller.record;

import com.example.letsgo.domain.record.Record;
import com.example.letsgo.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/record")
public class RecordController {

    private RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public String getRecord(int recordId) {
        recordService.getRecord(recordId);
        return "/record/view";
    }

    @GetMapping
    public String getAllRecords(int userId) {
        recordService.getAllRecords(userId);
        return "record/view";
    }

    @PostMapping
    public String addRecord(Record rec) {
        recordService.addRecord(rec);
        return "redirect:/record/add";
    }

    @PostMapping
    public String updateRecord(int recordId, Record rec) {
        recordService.updateRecord(recordId, rec);
        return "redirect:/record/update";
    }

    @DeleteMapping
    public String deleteRecord(int recordId) {
        recordService.deleteRecord(recordId);
        return "redirect:/record/delete";
    }
}
