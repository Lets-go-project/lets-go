package com.example.letsGo.service;

import com.example.letsGo.dao.ChallengeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeServiceImpl implements ChallengeService {
    @Autowired
    private ChallengeDao challengeDao;

    public List<Record> getPubAllRecords(int isPublic) {
        return challengeDao.getPubAllRecords(isPublic);
    }

    public List<Record> getPubWomanRecords(int isPublic, int gender) {
        return challengeDao.getPubWomanRecords(isPublic, gender);
    }

    public List<Record> getPubManRecords(int isPublic, int gender) {
        return challengeDao.getPubManRecords(isPublic, gender);
    }

    public void filteringRecords(List<Record> records, int filter) {
        challengeDao.filteringRecords(records, filter);
    }
}
