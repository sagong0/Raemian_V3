package org.example.ramian_pj.dto;


import lombok.Data;

@Data
public class SearchConditionDTO {
    private String keyword;

    // username, userid, user_tell
    private String searchType;

    private String sortBy = "userid";

    private String order = "desc";
    
    private int page = 1;
    
    // 한페이지당 출력 데이터 수
    private int pageSize = 5;
    
}
