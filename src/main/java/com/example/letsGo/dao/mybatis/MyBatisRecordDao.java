package com.example.letsGo.dao.mybatis;

import com.example.letsGo.dao.RecordDao;
import com.example.letsGo.dao.mybatis.mapper.RecordMapper;
import com.example.letsGo.domain.record.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisRecordDao implements RecordDao {

    private final RecordMapper recordMapper;

    @Autowired
    public MyBatisRecordDao(RecordMapper recordMapper) {
        this.recordMapper = recordMapper;
    }

    @Override
    public Record addRecord(Record record) {
        recordMapper.addRecord(record);
        return record;
    }

    @Override
    public Record updateRecord(int recordId, Record record) {
        recordMapper.updateRecord(recordId, record);
        return record;
    }

    @Override
    public void deleteRecord(int recordId) {
        recordMapper.deleteRecord(recordId);
    }

    @Override
    public Record getRecord(int recordId) {
        return recordMapper.getRecord(recordId);
    }

    @Override
    public List<Record> getAllRecords(int userId) {
        return recordMapper.getAllRecords(userId);
    }

}
