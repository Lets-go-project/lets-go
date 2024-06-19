package com.example.letsGo.controller.challenge;

import com.example.letsGo.domain.record.Record;
import com.example.letsGo.repository.RecordRepository;
import com.example.letsGo.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    RecordRepository recordRepository;

    private final ChallengeService challengeService;

    @Autowired
    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping("/all")
    public String getAllRecords(Model model) {

        List<Record> allRecords = recordRepository.findAll();

        model.addAttribute("records", allRecords);

        return "challenge/challenge";
    }

//    @GetMapping
//    public String getWomanRecords(int gender) {
//        challengeService.getWomanRecords(isPublic, gender);
//        return "challenge/woman";
//    }
//
//    @GetMapping
//    public String getManRecords(int gender) {
//        challengeService.getManRecords(isPublic, gender);
//        return "challenge/man";
//    }
//
//    @GetMapping
//    public String filteringRecords(List<Record> records, int filter) {
//        challengeService.filteringRecords(records, filter);
//        return "challenge/filtering";
//    }
}
