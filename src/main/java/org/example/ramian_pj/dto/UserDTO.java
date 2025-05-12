package org.example.ramian_pj.dto;

import lombok.Data;

@Data
public class UserDTO {
//    phone_verified,
    private Long id;
    private String userid;
    private String username;
    private String pw;
    private String phoneNumber;
    private String email;
    private String zipcode, streetAddress, detailAddress;
}
