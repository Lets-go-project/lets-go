package com.example.letsGo.dao;

import com.example.letsGo.domain.record.Record;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

public interface RecordDao {
    Record addRecord(Record record);
    Record updateRecord(Long recordId, Record record);
    void deleteRecord(Long recordId);
    Record getRecord(Long recordId);
    List<Record> getAllRecords(int userId);
}
