package com.example.duodome04.controller;

import com.example.duodome04.user.User;

public class UserRequestDTO {
    private String email;
    private String userId;
    private String name;
    private String password;

    public User toEntity() {
        return new User(email, userId, name, password);
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

    public String getEmail() {
        return email;
    }
}
