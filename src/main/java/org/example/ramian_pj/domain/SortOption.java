package org.example.ramian_pj.domain;

import java.util.Arrays;
import java.util.List;

public interface SortOption {

    // 회원 테이블 전용
    String userName = "username";
    String userId = "userid";
    String created_At = "created_at";


    // 공지사항 테이블 전용
    String noticeId = "notice_id";
    String reg_date = "reg_date";

    // Admin 관리자 테이블 전용
    String adminName = "name";
    String adminId = "userid";
    String adminPhone = "phone";



    // 회원 전용
    static List<String> values(){
        return Arrays.asList(userName, userId, created_At);
    }


    // 공지사항
    static List<String> noticeValues(){
        return Arrays.asList(noticeId, reg_date);
    }


    // Admin
    static List<String> adminValues(){return Arrays.asList(adminName, adminId, adminPhone);}

}
