package com.example.letsGo.dao.mybatis;

import com.example.letsGo.dao.ChallengeDao;
import com.example.letsGo.dao.mybatis.mapper.ChallengeMapper;
import com.example.letsGo.dao.mybatis.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisChallengeDao implements ChallengeDao {
    private final ChallengeMapper challengeMapper;

    @Autowired
    public MyBatisChallengeDao(ChallengeMapper challengeMapper) {
        this.challengeMapper = challengeMapper;
    }

    @Override
    public List<Record> getPubAllRecords() {
        return challengeMapper.getPubAllRecords();
    }
    @Override
    public List<Record> getPubWomanRecords(int gender) {
        return null;
    }

    @Override
    public List<Record> getPubManRecords(int gender) {
        return null;
    }

    @Override
    public void filteringRecords(List<Record> records, int filter) {

    }

    @Override
    public void sortRecordsByDist(List<Record> records) {

    }

    @Override
    public void sortRecordsByTime(List<Record> records) {

    }

    @Override
    public void sortRecordsByDate(List<Record> records) {

    }
}
