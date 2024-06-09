package com.vitabidome09;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;
    private String password;
    private UserType userType;
    private List<String> passwordHistory = new ArrayList<>();

    public User(String id, String password, UserType userType) {
        this.id = id;
        this.password = password;
        this.userType = userType;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
        this.passwordHistory.add(newPassword);
    }

    public String getLastChangedPassword() {
        if (passwordHistory.size() == 1) {
            return passwordHistory.get(passwordHistory.size() - 1);
        }
        return passwordHistory.get(passwordHistory.size() - 2);
    }

    public List<String> getPasswordHistory() {
        return passwordHistory;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }
}
