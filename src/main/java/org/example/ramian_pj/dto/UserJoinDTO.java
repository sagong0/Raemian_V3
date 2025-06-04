package org.example.ramian_pj.dto;

import lombok.Data;

@Data
public class UserJoinDTO {
    private String username;
    private String userid;
    private String pw;
    private String phoneNumber;
    private String email;
    private String zipcode;
    private String streetAddress;
    private String detailAddress;

    // 마케팅 수신여부 (동의 : True , 미동의 : False)
    private boolean agreeEmail;
    private boolean agreeTel;
    private boolean agreePost;
    private boolean agreeSms;
}
