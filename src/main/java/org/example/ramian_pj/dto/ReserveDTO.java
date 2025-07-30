package org.example.ramian_pj.dto;

import lombok.Data;

@Data
public class ReserveDTO {
    private int id;
    private int memberId;
    // 예약 일자
    private String rdate;
    // 예약 시간
    private String rtime;
    // 예약 인원
    private int rCount;
}
