package com.example.letsGo.domain.record;

import com.example.letsGo.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "Record")
public class Record extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    private String swimDate;
    private String swimName;
    private float swimTime;
    private float swimDist;
    private int userId;
    private String id;
    private String gender;

    @Override
    public String toString() {
        return "Record{" +
                "recordId=" + recordId +
                ", swimDate='" + swimDate + '\'' +
                ", swimName='" + swimName + '\'' +
                ", swimTime=" + swimTime +
                ", swimDist=" + swimDist +
                ", userId=" + userId +
                ", id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
