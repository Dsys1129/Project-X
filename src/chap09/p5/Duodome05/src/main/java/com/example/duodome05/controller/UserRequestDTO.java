package com.example.duodome05.controller;


import com.example.duodome05.user.User;

public class UserRequestDTO {
    private String userId;
    private String password;

    public User toEntity() {
        return new User(userId, password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }
}
