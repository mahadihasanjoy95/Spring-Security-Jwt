package com.security.SpringSecurityDemo.service.serviceImpl;

import com.security.SpringSecurityDemo.persistence.entity.User;
import com.security.SpringSecurityDemo.persistence.repository.UserRepository;
import com.security.SpringSecurityDemo.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public String userSignUp(String firstName, String lastName, String password, String email, String roles) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setRoles(roles);
        user.setActive(true);
        userRepository.save(user);
        return user.toString();
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
