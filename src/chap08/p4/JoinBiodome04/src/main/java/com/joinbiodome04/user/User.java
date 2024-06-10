package com.joinbiodome04.user;

import java.time.LocalDateTime;

public class User {
    private Long id;
    private String name;
    private Interest interest;
    private Team team;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

    public User(String name, Interest interest, Team team) {
        this.name = name;
        this.interest = interest;
        this.team = team;
        this.createdDate = LocalDateTime.now();
    }

    public Team getTeam() {
        return team;
    }

    public String getName() {
        return this.name;
    }


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Interest getInterest() {
        return interest;
    }
}
