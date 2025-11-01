package org.example.ramian_pj.dto;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;


@Data
public class FaqDTO {

    private Long id;
    private String question;
    private String answer;
    // 작성자
    private String writer;



    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
