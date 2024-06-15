package com.example.letsGo.service;

import com.example.letsGo.dao.mybatis.MyBatisChallengeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeServiceImpl implements ChallengeService {
    private final MyBatisChallengeDao challengeDao;

    @Autowired
    public ChallengeServiceImpl(MyBatisChallengeDao challengeDao) {
        this.challengeDao = challengeDao;
    }

    @Override
    public List<Record> getPubAllRecords() {
        return challengeDao.getPubAllRecords();
    }

    @Override
    public List<Record> getPubWomanRecords(int gender) {
        return challengeDao.getPubWomanRecords(gender);
    }

    @Override
    public List<Record> getPubManRecords(int gender) {
        return challengeDao.getPubManRecords(gender);
    }

    @Override
    public void filteringRecords(List<Record> records, int filter) {
        challengeDao.filteringRecords(records, filter);
    }
}
