package com.joinbiodome02;

import com.joinbiodome02.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private Long idx = 1L;
    private Map<Long, User> userMap = new HashMap<>();
    private List<String> updateHistoryList = new ArrayList<>();

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


    public void update(User user, LocalDateTime localDateTime) {
        user.setUpdateDate(localDateTime);
        userMap.put(user.getId(), user);
    }

    public User findUserById(Long userId) {
        return userMap.get(userId);
    }
}
