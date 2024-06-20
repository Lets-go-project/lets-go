package com.example.letsGo.repository;

import com.example.letsGo.domain.record.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    Record findByRecordId(Long recordId);
    List<Record> findByUserId(int userId);

    //기록 정렬 함수들
    List<Record> findByUserIdOrderBySwimDateDesc(int userId);
    List<Record> findByUserIdOrderBySwimTimeDesc(int userId);
    List<Record> findByUserIdOrderBySwimDistDesc(int userId);

    //챌린지 관련 함수들
    List<Record> findAllByOrderBySwimDistDesc();
    List<Record> findByGenderOrderBySwimDistDesc(String gender);
}
