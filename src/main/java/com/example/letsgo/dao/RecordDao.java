package com.example.letsgo.dao;

import com.example.letsgo.domain.record.Record;

import java.util.List;

public interface RecordDao {
    Record addRecord(Record record);
    Record updateRecord(int recordId, Record record);
    void deleteRecord(int recordId);
    Record getRecord(int recordId);
    List<Record> getAllRecords(int userId);
}
