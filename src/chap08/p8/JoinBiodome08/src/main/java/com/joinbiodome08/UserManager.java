package com.joinbiodome08;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {
    private ConcurrentHashMap<String, User> userMap = new ConcurrentHashMap<>();

    public UserManager() {
        userMap.put("user1", new User("user1", 20));
        userMap.put("user2", new User("user2", 0));
        userMap.put("user3", new User("user3", 50));
    }

    public void save(User user) {
        userMap.put(user.getName(), user);
    }

    public User findUser(String name) {
        User user = userMap.get(name);
        if (user == null) {
            throw new IllegalArgumentException("해당하는 유저가 없습니다.");
        }
        return user;
    }

    public void increasePoint(String name, int point) {
        User user = userMap.get(name);
        user.increasePoint(point);
    }

    public void decreasePoint(String name, int point) {
        User user = userMap.get(name);
        user.decreasePoint(point);
    }
}
