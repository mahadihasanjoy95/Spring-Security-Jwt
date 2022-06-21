package com.security.SpringSecurityDemo.service.serviceImpl;

import com.security.SpringSecurityDemo.dto.SignUpResponse;
import com.security.SpringSecurityDemo.persistence.entity.User;
import com.security.SpringSecurityDemo.persistence.repository.UserRepository;
import com.security.SpringSecurityDemo.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public SignUpResponse userSignUp(String firstName, String lastName, String password, String email, String roles) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setRoles(roles);
        user.setActive(true);
        User existingUser = userRepository.findUserByEmail(email);
        if (Objects.nonNull(existingUser)) {
            return null;
        } else {
            userRepository.save(user);
            SignUpResponse signUpResponse = new SignUpResponse();
            signUpResponse.setName(user.getFirstName() + " " + user.getLastName());
            signUpResponse.setEmail(user.getEmail());
            signUpResponse.setId(user.getId());
            return signUpResponse;
        }
    }

    @Override
    public String userSignIn(String email, String password) {
        return null;
    }

    @Override
    public User userDetails(String email) {
        User user = userRepository.findUserByEmail(email);
        return user;
    }
}
