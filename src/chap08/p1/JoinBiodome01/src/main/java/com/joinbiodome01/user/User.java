package com.joinbiodome01.user;

import com.joinbiodome01.UserRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String name;
    private List<Interest> interest = new ArrayList<>();
    private Team team;
    private LocalDateTime createdDate;
    private String email;

    private User(String name, List<Interest> interest, Team team, String email) {
        this.name = name;
        this.interest = interest;
        this.team = team;
        this.email = email;
        this.createdDate = LocalDateTime.now();
    }

    private User(String name, Team team, String email) {
        this.name = name;
        this.team = team;
        this.email = email;
    }

    public static User createUserWithoutInterest(UserRequest userRequest) {
        return new User(userRequest.getName(), Team.valueOf(userRequest.getTeam()), userRequest.getEmail());
    }

    public static User createUserWithInterest(UserRequest userRequest) {
        List<Interest> interests = new ArrayList<>();
        for (String interestName : userRequest.getInterests()) {
            interests.add(Interest.valueOf(interestName));
        }

        return new User(userRequest.getName(), interests, Team.valueOf(userRequest.getTeam()), userRequest.getEmail());
    }

    public Team getTeam() {
        return team;
    }

    public String getName() {
        return this.name;
    }

    public List<Interest> getInterest() {
        return interest;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
