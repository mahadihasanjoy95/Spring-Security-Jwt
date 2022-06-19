package com.security.SpringSecurityDemo.service.contract;

import com.security.SpringSecurityDemo.dto.SignUpResponse;
import com.security.SpringSecurityDemo.persistence.entity.User;

public interface UserService {

    SignUpResponse userSignUp(String firstName, String lastName, String password, String email, String roles);

    String userSignIn(String email, String password);

    User userDetails(String email);
}
