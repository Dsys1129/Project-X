package com.vitabidome09;

public class AuthenticationRequest {

    private String id;
    private String password;

    public AuthenticationRequest(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
