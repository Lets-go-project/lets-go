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
    public List<Record> getAllRecords() {
        return challengeDao.getAllRecords();
    }

    @Override
    public List<Record> getWomanRecords(int gender) {
        return challengeDao.getWomanRecords(gender);
    }

    @Override
    public List<Record> getManRecords(int gender) {
        return challengeDao.getManRecords(gender);
    }

    @Override
    public void filteringRecords(List<Record> records, int filter) {
        challengeDao.filteringRecords(records, filter);
    }
}
