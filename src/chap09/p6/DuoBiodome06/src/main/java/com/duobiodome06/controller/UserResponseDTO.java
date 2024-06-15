package com.duobiodome06.controller;

public class UserResponseDTO {

    private String userId;

    public UserResponseDTO(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
