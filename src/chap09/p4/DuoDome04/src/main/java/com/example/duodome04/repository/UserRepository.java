package com.example.duodome04.repository;

import com.example.duodome04.exception.custom.UserAlreadyExistException;
import com.example.duodome04.user.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class UserRepository {

    private HashMap<String, User> userMap = new HashMap<>();

    public User findById(String userId) {
        return userMap.get(userId);
    }

    public void save(User user) {
        if (userMap.containsKey(user.getUserId())) {
            throw new UserAlreadyExistException("이미 존재하는 사용자입니다.");
        }
        userMap.put(user.getUserId(), user);
    }

    public void updatePassword(User user) {
        userMap.put(user.getUserId(), user);
    }

    public void deleteUser(User user) {
        userMap.remove(user.getUserId());
    }
}
