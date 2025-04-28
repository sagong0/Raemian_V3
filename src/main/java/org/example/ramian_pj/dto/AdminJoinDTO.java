package org.example.ramian_pj.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter @Setter @ToString
public class AdminJoinDTO {
    // 지역
    private String aarea;
    // 소속 부서
    private String adept;
    // 이름
    private String aname;
    // 직책
    private String aposition;
    // 아이디
    @NotBlank(message = "사용하실 아이디를 입력해주세요.")
    private String aid;

    @Size(min = 6, message = "6자 이상 패스워드 사용해주세요.")
    @NotBlank
    private String apw1;
    @Email(message = "이메일 형식 확인해주세요.")
    private String aemail;
    private String atell;
}
