package org.example.ramian_pj.dto;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class NoticeDTO {
    private String ntitle;
    private String nwriter;
    private String ncontent;
    private MultipartFile nfile;
}
