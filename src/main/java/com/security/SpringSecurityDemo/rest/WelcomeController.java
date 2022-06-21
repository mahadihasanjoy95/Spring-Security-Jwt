package com.security.SpringSecurityDemo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @RequestMapping(path = "/")
    public String welcome() {
        return "<h1>Welcome</h1>";
    }
}
