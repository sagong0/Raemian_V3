package org.example.ramian_pj.dto;


import lombok.Data;

import java.util.List;

@Data
public class PageDTO<T> {

    // 실제 데이터 리스트
    private List<T> list;

    // 전체 항목 개수
    private int totalCount;

    // 현재 페이지
    private int currentPage;

    // 페이지당 항목 수
    private int pageSize;


    // 전체 페이지 수
    public int getTotalPages(){
        return (int)Math.ceil((double) totalCount / pageSize);
    }

    // 이전 페이지 존재 여부
    public boolean hasPrev(){
        return currentPage > 1;
    }

    // 다음 페이지 존재 여부
    public boolean hasNext(){
        return currentPage < getTotalPages();
    }

    // 이전 페이지 번호
    public int getPrevPage() {
        return hasPrev() ? currentPage - 1 : 1;
    }

    // 다음 페이지 번호
    public int getNextPage() {
        return hasNext() ? currentPage + 1 : getTotalPages();
    }


}
