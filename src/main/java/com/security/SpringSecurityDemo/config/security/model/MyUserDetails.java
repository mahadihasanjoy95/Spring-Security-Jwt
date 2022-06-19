package com.security.SpringSecurityDemo.config.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.security.SpringSecurityDemo.persistence.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails implements UserDetails {

    private String userName;
    private Long id;
    private String firstName;
    private String lastName;
    private boolean active;
    private String roles;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public MyUserDetails(String userName, Long id, String password, String firstName, String lastName, boolean active, String roles, Collection<? extends GrantedAuthority> authorities) {
        this.userName = userName;
        this.id = id;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorities = authorities;
        this.active = active;
        this.roles = roles;
    }

    public static MyUserDetails build(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        return new MyUserDetails(
                user.getEmail(),
                user.getId(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName(),
                user.isActive(),
                user.getRoles(),
                authorities
        );
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}
