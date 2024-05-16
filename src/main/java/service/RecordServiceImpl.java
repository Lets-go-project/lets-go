package service;

import dao.RecordDao;
import domain.record.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;

    @Override
    public Record getRecord(int recordId) {
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
    public Record updateRecord(int recordId, Record record) {
        return recordDao.updateRecord(recordId, record);
    }

    @Override
    public void deleteRecord(int recordId) {
        recordDao.deleteRecord(recordId);
    }
}
