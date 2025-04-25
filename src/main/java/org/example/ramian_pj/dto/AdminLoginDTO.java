package org.example.ramian_pj.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class AdminLoginDTO {

    @NotBlank
    @Size(min = 6,message = "Admin ID must be at least 6 characters long !")
    private String aid;

    @NotBlank
    @Size(min = 6, message = "Admin Password must be at least 6 characters long !" )
    private String apw;
}
