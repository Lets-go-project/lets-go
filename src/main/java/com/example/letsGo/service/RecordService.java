package com.example.letsGo.service;

import com.example.letsGo.domain.record.Record;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecordService {
    Record getRecord(Long recordId);
    List<Record> getAllRecords(int userId);
    Record addRecord(Record record);
    Record updateRecord(Long recordId, Record record);
    void deleteRecord(Long recordId);
}
