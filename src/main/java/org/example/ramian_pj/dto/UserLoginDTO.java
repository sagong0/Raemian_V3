package org.example.ramian_pj.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserLoginDTO {
    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min = 6,message = "6자 이상의 아이디를 입력해주세요.")
    private String aid;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 6, message = "패스워드를 확인해주세요." )
    private String apw;
}
