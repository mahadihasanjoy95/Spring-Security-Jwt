package com.security.SpringSecurityDemo.config.security.service;

import com.security.SpringSecurityDemo.config.security.model.MyUserDetails;
import com.security.SpringSecurityDemo.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsServiceImpl implements MyUserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails userDetails =  MyUserDetails.build(userService.userDetails(email));
        return userDetails;
    }
}
