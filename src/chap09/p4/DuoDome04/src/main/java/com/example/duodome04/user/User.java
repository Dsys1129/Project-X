package com.example.duodome04.user;

public class User {

    private String email;
    private String userId;
    private String name;
    private String password;

    public User(String email, String userId, String name, String password) {
        this.email = email;
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
