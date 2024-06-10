package com.joinbiodome03;

import java.util.ArrayList;
import java.util.List;

public class UserRequest {
    private String name;
    private List<String> interests = new ArrayList<>();
    private String team;
    private String email;

    public UserRequest() {
    }

    public UserRequest(String name, List<String> interests, String team, String email) {
        this.name = name;
        this.interests = interests;
        this.team = team;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }

    public List<String> getInterests() {
        return interests;
    }
}
