package org.example.ramian_pj.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginDTO {
    @NotBlank
    @Size(min = 6,message = "6자 이상의 아이디를 입력해주세요.")
    private String id;

    @NotBlank
    @Size(min = 6, message = "패스워드를 확인해주세요." )
    private String pw;
}
