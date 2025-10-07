package org.example.ramian_pj.dto;

import lombok.Data;

@Data
public class AdminMemberDTO {
    private Long id;
    // 소속
    private String department;
    // 부서
    private String subDepartment;
    // 사용자 이름
    // 사용자 id
    private String name;
    private String userid;
    // 패스워드
    private String pw;
    private String email;
    private String phone;
    // 직책
    private String position;

    // 삭제 여부(활성화 여부)
    private String deletedAt;
}
