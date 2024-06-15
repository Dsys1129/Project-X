package com.example.duodome05.user;

public class User {

    private String userId;
    private String password;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }
}
