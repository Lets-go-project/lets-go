package com.example.letsGo.service;

import com.example.letsGo.dao.mybatis.MyBatisRecordDao;
import com.example.letsGo.domain.record.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    private final MyBatisRecordDao recordDao;

    @Autowired
    public RecordServiceImpl(MyBatisRecordDao recordDao) {
        this.recordDao = recordDao;
    }

    @Override
    public Record getRecord(Long recordId) {
        return recordDao.getRecord(recordId);
    }

    @Override
    public List<Record> getAllRecords(int userId) {
        return recordDao.getAllRecords(userId);
    }

    @Override
    public Record addRecord(Record record) {
        return recordDao.addRecord(record);
    }

    @Override
    public Record updateRecord(Long recordId, Record record) {
        return recordDao.updateRecord(recordId, record);
    }

    @Override
    public void deleteRecord(Long recordId) {
        recordDao.deleteRecord(recordId);
    }
}
