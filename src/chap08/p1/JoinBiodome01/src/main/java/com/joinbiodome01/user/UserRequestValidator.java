package com.joinbiodome01.user;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRequestValidator {

    private static final int MAX_EMAIL_LENGTH = 100;
    private static final Set<String> teams = new HashSet<>(Arrays.asList("SPRINGWATT", "WILDAVENGERS", "BERRYMASTERS",
            "DENDROLOGY", "GREENDYNAMO"));
    private static final Set<String> interests = new HashSet<>(Arrays.asList("GRAVBY", "WALKING", "COOKING",
            "PHOTOGRAPHY", "MUSIC", "BALLET", "CLIMBING", "LANGUAGE"));


    public static void validateUserRequest(String name, String email, String team, List<String> interestList) {
        validateName(name);
        validateEmail(email);
        validateTeam(team);
        validateInterest(interestList);
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(name + "은 올바르지 않은 입력입니다.");
        }
    }

    private static void validateEmail(String email) {
        if (email == null || email.isBlank() || email.length() > MAX_EMAIL_LENGTH) {
            throw new IllegalArgumentException(email + "은 올바르지 않은 입력입니다. 가능한 글자수는 0 ~ 100 입니다.");
        }
    }

    private static void validateTeam(String team) {
        if (team == null || team.isBlank() || !teams.contains(team)) {
            throw new IllegalArgumentException(team + "은 올바르지 않은 입력입니다.");
        }
    }

    private static void validateInterest(List<String> interestList) {
        for (String interest : interestList) {
            if (interest.isBlank() || !interests.contains(interest)) {
                throw new IllegalArgumentException(interest + "은 올바르지 않은 입력입니다.");
            }
        }
    }
}
