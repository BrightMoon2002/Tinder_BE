package com.codegym.model.account;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String username;
    private String name;
    private String oneRole;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String accessToken, Long id, String username, String name,String oneRole ,Collection<? extends GrantedAuthority> roles) {
        this.token = accessToken;
        this.username = username;
        this.roles = roles;
        this.name = name;
        this.id = id;
        this.oneRole = oneRole;
    }

    public JwtResponse(String accessToken, String type, String username, String name, String oneRole, Collection<? extends GrantedAuthority> roles) {
        this.token = accessToken;
        this.type = type;
        this.username = username;
        this.name = name;
        this.oneRole = oneRole;
        this.roles = roles;
    }

    public JwtResponse(String token, String type, String username, String name, String oneRole) {
        this.token = token;
        this.type = type;
        this.username = username;
        this.name = name;
        this.oneRole = oneRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOneRole() {
        return oneRole;
    }

    public void setOneRole(String oneRole) {
        this.oneRole = oneRole;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}