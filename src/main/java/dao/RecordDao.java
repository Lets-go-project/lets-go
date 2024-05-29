package dao;

import domain.record.Record;

import java.util.List;

public interface RecordDao {
    Record addRecord(Record record);
    Record updateRecord(int recordId, Record record);
    void deleteRecord(int recordId);
    Record getRecord(int recordId);
    List<Record> getAllRecords(int userId);
}
