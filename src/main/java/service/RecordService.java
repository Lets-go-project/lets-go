package service;

import domain.record.Record;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecordService {
    Record getRecord(int recordId);
    List<Record> getAllRecords(int userId);
    Record addRecord(Record record);
    Record updateRecord(int recordId, Record record);
    void deleteRecord(int recordId);
}
