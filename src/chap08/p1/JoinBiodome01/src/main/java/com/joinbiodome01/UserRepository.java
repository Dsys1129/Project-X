package com.joinbiodome01;

import com.joinbiodome01.exception.DuplicatedUserException;
import com.joinbiodome01.user.Interest;
import com.joinbiodome01.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepository {
    private Long idx = 1L;
    private Map<String, User> userMap = new HashMap<>();
    private Map<Long, User> bonusUserMap = new HashMap<>();

    public void save(User user) {
        if (isExists(user.getName())) {
            throw new DuplicatedUserException("중복된 사용자 이름입니다.");
        }
        this.userMap.put(user.getName(), user);
    }

    public void saveWithId(User user) {
        user.setId(idx);
        this.bonusUserMap.put(idx, user);
        idx++;
    }

    public List<User> findAll() {
        return this.userMap.values().stream().collect(Collectors.toList());
    }

    public boolean isExists(String name) {
        if (userMap.containsKey(name)) {
            return true;
        }
        return false;
    }

    public List<User> findUserByInterest(String interest) {
        List<User> result = new ArrayList<>();
        for (User user : userMap.values()) {
            for (Interest userInterest : user.getInterest()) {
                if (userInterest.name().equals(interest)) {
                    result.add(user);
                }
            }
        }
        return result;
    }

    public List<User> findUserByTeam(String team) {
        List<User> result = new ArrayList<>();
        for (User user : userMap.values()) {
            if (user.getTeam().name().equals(team)) {
                result.add(user);
            }
        }
        return result;
    }

    public User findUserById(Long id) {
        for (Long idx : bonusUserMap.keySet()) {
           if (idx.equals(id)) {
               return bonusUserMap.get(idx);
           }
        }
        return null;
    }
}
