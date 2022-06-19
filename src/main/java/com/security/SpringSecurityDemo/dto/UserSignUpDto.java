package com.security.SpringSecurityDemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String roles;
}
