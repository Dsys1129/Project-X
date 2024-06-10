package com.joinbiodome01;

import com.joinbiodome01.user.User;
import com.joinbiodome01.user.UserRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class UserRequest {
    private String name;
    private List<String> interests = new ArrayList<>();
    private String team;
    private String email;

    // GSON : 기본 생성자로 객체를 생성 후 리플렉션을 통해 필드에 직접 접근한다.
    private UserRequest() {
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

    public User toUser() {
        UserRequestValidator.validateUserRequest(name, email, team, interests);
        if (interests.isEmpty()) {
            return User.createUserWithoutInterest(this);
        }
        return User.createUserWithInterest(this);
    }
}
