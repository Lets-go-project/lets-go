package com.example.letsgo.service;

import com.example.letsgo.dao.RecordDao;
import com.example.letsgo.domain.record.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;

    public Record getRecord(int recordId) {
        return recordDao.getRecord(recordId);
    }

    public List<Record> getAllRecords(int userId) {
        return recordDao.getAllRecords(userId);
    }

    public Record addRecord(Record record) {
        return recordDao.addRecord(record);
    }

    public Record updateRecord(int recordId, Record record) {
        return recordDao.updateRecord(recordId, record);
    }

    public void deleteRecord(int recordId) {
        recordDao.deleteRecord(recordId);
    }
}
