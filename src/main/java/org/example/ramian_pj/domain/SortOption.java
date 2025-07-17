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


    static List<String> values(){
        return Arrays.asList(userName, userId, created_At);
    }

    static List<String> noticeValues(){
        return Arrays.asList(noticeId, reg_date);
    }
}
