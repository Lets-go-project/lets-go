package com.example.letsGo.dao;

import java.util.List;

public interface ChallengeDao {
    List<Record> getPubAllRecords();
    List<Record> getPubWomanRecords(int gender);
    List<Record> getPubManRecords(int gender);

    void filteringRecords(List<Record> records, int filter);
    void sortRecordsByDist(List<Record> records);
    void sortRecordsByTime(List<Record> records);
    void sortRecordsByDate(List<Record> records);
}
