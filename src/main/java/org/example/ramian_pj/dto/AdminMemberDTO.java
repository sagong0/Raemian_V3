package org.example.ramian_pj.dto;

import lombok.Data;

@Data
public class AdminMemberDTO {
    private Long id;
    // 소속
    private String department;
    // 부서
    private String sub_department;
    // 사용자 이름
    private String name;
    // 사용자 id
    private String userid;
    // 패스워드
    private String pw;
    private String email;
    private String phone;
    // 직책
    private String position;
}
