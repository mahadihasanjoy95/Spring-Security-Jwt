package com.security.SpringSecurityDemo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserSignUpDto {
    private String firstName;
    private String lastName;
    @Email
    private String email;
    @Size(min = 8, message = "{Password too short}")
    @Size(max = 50, message = "{Password too long}")
    private String password;
    private String roles;
}
