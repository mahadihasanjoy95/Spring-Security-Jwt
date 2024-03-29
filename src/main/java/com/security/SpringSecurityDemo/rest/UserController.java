package com.security.SpringSecurityDemo.rest;

import com.security.SpringSecurityDemo.config.security.model.MyUserDetails;
import com.security.SpringSecurityDemo.config.security.service.MyUserDetailsService;
import com.security.SpringSecurityDemo.dto.*;
import com.security.SpringSecurityDemo.service.contract.UserService;
import com.security.SpringSecurityDemo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.OK;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Autowired
    JwtUtil jwtUtil;

    @RequestMapping(path = "/signUp")
    public ResponseEntity<Object> userSignUp(@Valid @RequestBody UserSignUpDto userSignUpDto) {
        SignUpResponse result = userService.userSignUp(userSignUpDto.getFirstName(), userSignUpDto.getLastName(), userSignUpDto.getPassword(), userSignUpDto.getEmail(), userSignUpDto.getRoles());
        if (!Objects.nonNull(result)) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse(CONFLICT.value(), "User Already Exists!", result));
        } else {
            return ResponseEntity.ok().body(new ApiResponse(OK.value(), "User Created Successfully", result));
        }

    }

    @RequestMapping(path = "/signIn", method = RequestMethod.POST)
    public ResponseEntity<?> userSignIn(@RequestBody UserSignInCommand userSignInCommand) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userSignInCommand.getEmail(), userSignInCommand.getPassword())
            );
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Bad Credentials");
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(userSignInCommand.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok().body(new SignInResponse(jwt));

    }

    @RequestMapping(path = "/admin")
    public String admin() {
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "<h1>Welcome " + user.getUsername() + "</h1>";
    }

    @RequestMapping(path = "/user")
    public String user() {
        return "<h1>Welcome User</h1>";
    }


}
