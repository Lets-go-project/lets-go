package com.example.letsGo.service;

import com.example.letsGo.domain.record.Record;

import java.util.List;

public interface ChallengeService {
    List<Record> getAllRecords();
    List<Record> getWomanRecords(int gender);
    List<Record> getManRecords(int gender);
    void filteringRecords(List<Record> records, int filter);
}
