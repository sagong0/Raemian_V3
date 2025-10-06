package org.example.ramian_pj.dto;


import lombok.Data;

@Data
public class AdminReserveDTO {


    // 아이디
    private String userId;

    //고객명
    private String userName;

    // 연락처
    private String userTell;


    // client_member.id 외래키 관계
    private int memberId;
    // 예약 일자
    private String rdate;
    // 예약 시간
    private String rtime;

    // 예약 인원
    private int rcount;
}
