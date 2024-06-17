package com.example.letsGo.dao;

import com.example.letsGo.domain.record.Record;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

public interface RecordDao {
    Record addRecord(Record record);
    Record updateRecord(int recordId, Record record);
    void deleteRecord(int recordId);
    Record getRecord(int recordId);
    List<Record> getAllRecords(int userId);
}
