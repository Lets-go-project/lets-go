package com.example.letsGo.dao.mybatis;

import com.example.letsGo.dao.RecordDao;
import com.example.letsGo.dao.mybatis.mapper.RecordMapper;
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
        return null;
    }

    @Override
    public Record updateRecord(int recordId, Record record) {
        return null;
    }

    @Override
    public void deleteRecord(int recordId) {

    }

    @Override
    public Record getRecord(int recordId) {
        return null;
    }

    @Override
    public List<Record> getAllRecords(int userId) {
        return null;
    }
}
