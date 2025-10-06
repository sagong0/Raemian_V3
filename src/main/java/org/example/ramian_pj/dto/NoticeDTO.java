package org.example.ramian_pj.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class NoticeDTO {
    private Integer noticeId;
    private String ntitle;
    private String nwriter;
    private String ncontent;
    private Date regDate;

    // 조회수 카운트
    private int ncount;

    // 업로드용
    private MultipartFile nfile;

    // 파일 조회용
    private NoticeFileDTO fileInfo;
}
