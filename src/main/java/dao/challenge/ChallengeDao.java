package dao.challenge;

import domain.record.Record;

import java.util.List;

public interface ChallengeDao {
    List<Record> getPubAllRecords(int isPublic);
    List<Record> getPubWomanRecords(int isPublic, int gender);
    List<Record> getPubManRecords(int isPublic, int gender);

    void filteringRecords(List<Record> records, int filter);
    void sortRecordsByDist(List<Record> records);
    void sortRecordsByTime(List<Record> records);
    void sortRecordsByDate(List<Record> records);
}
