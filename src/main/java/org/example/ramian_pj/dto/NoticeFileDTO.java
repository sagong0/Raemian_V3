package org.example.ramian_pj.dto;

import lombok.Data;

@Data
public class NoticeFileDTO {
    private int fileId;
    // FK -> NoticeDTO 의 noticeId 필요
    private int noticeId;
    // UUID 저장명
    private String fileName;
    // CDN 경로
    private String filePath;
    private long fileSize;
    private String contentType;
}
