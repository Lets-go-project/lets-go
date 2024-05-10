package service;

import domain.record.Record;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChallengeService {
    List<Record> getPubAllRecords(int isPublic);
    List<Record> getPubWomanRecords(int isPublic, int gender);
    List<Record> getPubManRecords(int isPublic, int gender);
    void filteringRecords(List<Record> records, int filter);
}
