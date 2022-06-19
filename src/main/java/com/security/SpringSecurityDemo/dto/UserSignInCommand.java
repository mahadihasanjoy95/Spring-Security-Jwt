package com.security.SpringSecurityDemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInCommand {
    private String email;
    private String password;

}
