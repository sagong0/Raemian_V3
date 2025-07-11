package org.example.ramian_pj.dto;

import lombok.Data;

@Data
public class NoticeFileDTO {
    private int id;
    private int noticeId;
    private String fileName;
    private String filePath;
    private long fileSize;
    private String contentType;
}
