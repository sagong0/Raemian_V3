package org.example.ramian_pj.domain;

import java.time.LocalDateTime;

public class User {
    private Long id;
    // 아이디
    private String userid;
    // 이름
    private String username;
    // 비번
    private String pw;
    // 휴대번호
    private String phoneNumber;
    // 휴대번호 인증 여부
    private Boolean phoneVerified;
    // 이메일
    private String email;
    // 우편번호
    private String zipcode;
    // 도로명 주소
    private String streetAddress;
    // 상세주소
    private String detailAddress;
    // 생성일자
    private LocalDateTime createdAt;
    // 최종 수정일자
    private LocalDateTime updatedAt;
}
