package org.example.ramian_pj.domain;

import lombok.Getter;
import lombok.ToString;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;



@Getter
@ToString
public class Reserve {

    private int id;

    // member TABLE - F KEY
    private int memberId;

    // 예약 일자
    private Date reserveDate;
    // 예약 시간
    private Time reserveTime;

    // 예약 인원
    private int rCount;

    private Timestamp createdAt;
    private Timestamp updatedAt;
}
