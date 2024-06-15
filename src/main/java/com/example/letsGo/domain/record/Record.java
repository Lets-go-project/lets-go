package com.example.letsGo.domain.record;

import com.example.letsGo.domain.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Record extends BaseEntity {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordId;

    private String swimName;
    private String swimTime;
    private float swimDist;
    private int userId;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getSwimName() {
        return swimName;
    }

    public void setSwimName(String swimName) {
        this.swimName = swimName;
    }

    public String getSwimTime() {
        return swimTime;
    }

    public void setSwimTime(String swimTime) {
        this.swimTime = swimTime;
    }

    public float getSwimDist() {
        return swimDist;
    }

    public void setSwimDist(float swimDist) {
        this.swimDist = swimDist;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
