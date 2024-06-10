package com.joinbiodome03;

import com.joinbiodome03.user.User;

import java.time.LocalDateTime;
import java.util.*;

public class UserRepository {
    private Long idx = 1L;
    private Map<Long, User> userMap = new HashMap<>();

    public UserRepository() {
        UserRequest userRequest1 = new UserRequest("name1", List.of("GRAVBY", "COOKING"), "SPRINGWATT", "email1@naver.com");
        User user1 = User.createUserWithInterest(userRequest1);
        UserRequest userRequest2 = new UserRequest("name2",null ,"WILDAVENGERS", "email2@naver.com");
        User user2 = User.createUserWithoutInterest(userRequest2);

        save(user1);
        save(user2);
    }

    public void save(User user) {
        user.setId(idx);
        this.userMap.put(idx, user);
        idx++;
    }

    public Optional<User> findUserById(Long userId) {
        return Optional.of(userMap.get(userId));
    }

    public void delete(User user) {
        userMap.remove(user.getId());
    }
}
