package com.duodome9.user.controller;


import com.duodome9.user.User;
import lombok.Getter;

@Getter
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
