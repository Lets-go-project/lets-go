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
    public List<Record> getPubAllRecords(int isPublic) {
        return challengeDao.getPubAllRecords(isPublic);
    }

    @Override
    public List<Record> getPubWomanRecords(int isPublic, int gender) {
        return challengeDao.getPubWomanRecords(isPublic, gender);
    }

    @Override
    public List<Record> getPubManRecords(int isPublic, int gender) {
        return challengeDao.getPubManRecords(isPublic, gender);
    }

    @Override
    public void filteringRecords(List<Record> records, int filter) {
        challengeDao.filteringRecords(records, filter);
    }
}
