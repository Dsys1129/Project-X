package com.duodome08.user;

import lombok.Getter;

@Getter
public class User {

    private String userId;
    private String password;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}
