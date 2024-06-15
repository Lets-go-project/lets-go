package com.example.letsGo.dao.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChallengeMapper {
    List<Record> getPubAllRecords();
    List<Record> getPubWomanRecords(int isPublic, int gender);
    List<Record> getPubManRecords(int isPublic, int gender);

    void filteringRecords(List<Record> records, int filter);
    void sortRecordsByDist(List<Record> records);
    void sortRecordsByTime(List<Record> records);
    void sortRecordsByDate(List<Record> records);

}
