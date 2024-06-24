package com.duodome13.user.controller;

import lombok.Getter;

@Getter
public class UserResponseDTO {

    private String userId;

    public UserResponseDTO(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
