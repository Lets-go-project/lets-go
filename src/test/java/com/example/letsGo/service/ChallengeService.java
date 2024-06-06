package com.example.letsGo.service;

import java.util.List;

public interface ChallengeService {
    List<Record> getPubAllRecords(int isPublic);
    List<Record> getPubWomanRecords(int isPublic, int gender);
    List<Record> getPubManRecords(int isPublic, int gender);
    void filteringRecords(List<Record> records, int filter);
}
