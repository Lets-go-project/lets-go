package com.example.letsGo.dao.mybatis.mapper;

import com.example.letsGo.domain.record.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper {
    Record addRecord(Record record);
    Record updateRecord(int recordId, Record record);
    void deleteRecord(int recordId);
    Record getRecord(int recordId);
    List<Record> getAllRecords(int userId);
}
