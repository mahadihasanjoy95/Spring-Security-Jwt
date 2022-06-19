package com.security.SpringSecurityDemo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponse {
    private String name;
    private Long id;
    private String email;
}
