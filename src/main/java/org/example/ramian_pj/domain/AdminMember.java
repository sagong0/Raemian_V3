package org.example.ramian_pj.domain;

import java.sql.Timestamp;

public class AdminMember {
    private int id;
    // 소속
    private String department;
    // 부서
    private String sub_department;
    // 사용자 이름
    private String name;
    // 사용자 id
    private String userid;
    // 암호화된 pw
    private String pw;
    private String email;
    private String phone;
    // 직책
    private String position;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
}
