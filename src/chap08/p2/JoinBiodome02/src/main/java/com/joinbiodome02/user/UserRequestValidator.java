package com.joinbiodome02.user;

import com.joinbiodome02.UserRequest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRequestValidator {

    private static final int MAX_EMAIL_LENGTH = 100;
    private static final Set<String> teams = new HashSet<>(Arrays.asList("SPRINGWATT", "WILDAVENGERS", "BERRYMASTERS", "DENDROLOGY", "GREENDYNAMO"));
    private static final Set<String> interests = new HashSet<>(Arrays.asList("GRAVBY", "WALKING", "COOKING", "PHOTOGRAPHY", "MUSIC", "BALLET", "CLIMBING", "LANGUAGE"));


    public static void validateUserRequest(UserRequest userRequest) {
        validateName(userRequest.getName());
        validateEmail(userRequest.getEmail());
        validateTeam(userRequest.getTeam());
        validateInterest(userRequest.getInterests());
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름 : 올바르지 않은 입력입니다.");
        }
    }

    private static void validateEmail(String email) {
        if (email == null || email.isBlank() || email.length() > MAX_EMAIL_LENGTH) {
            throw new IllegalArgumentException("이메일 : 올바르지 않은 입력입니다. 가능한 최대 글자수는 100입니다.");
        }
    }

    private static void validateTeam(String team) {
        if (team == null || team.isBlank() || !teams.contains(team)) {
            throw new IllegalArgumentException("팀 : 올바르지 않은 입력입니다.");
        }
    }

    private static void validateInterest(List<String> interestList) {
        for (String interest : interestList) {
            if (interest.isBlank() || !interests.contains(interest)) {
                throw new IllegalArgumentException("관심사 : 올바르지 않은 입력입니다.");
            }
        }
    }
}
