package com.example.letsGo.service;

import java.util.List;

public interface ChallengeService {
    List<Record> getPubAllRecords();
    List<Record> getPubWomanRecords(int gender);
    List<Record> getPubManRecords(int gender);
    void filteringRecords(List<Record> records, int filter);
}
