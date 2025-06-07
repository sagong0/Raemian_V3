package org.example.ramian_pj.dto;

import lombok.Data;

@Data
public class UserJoinDTO {
    private String mname;
    private String mid;
    private String mpw;
    private String mtel;
    private String memail;
    private String mzipcode;
    private String mstreetaddr;
    private String mdetailaddr;

    // 마케팅 수신여부 (동의 : True , 미동의 : False)
    private String agreeEmail;
    private String agreeTel;
    private String agreePost;
    private String agreeSms;

    // 서버 기본 정책값 → 기본값 true 로
    private Boolean phoneVerified = true;
}
