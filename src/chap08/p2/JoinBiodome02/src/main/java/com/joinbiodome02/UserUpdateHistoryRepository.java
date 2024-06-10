package com.joinbiodome02;

import com.joinbiodome02.user.UserUpdateHistory;

import java.util.ArrayList;
import java.util.List;

public class UserUpdateHistoryRepository {
    private List<UserUpdateHistory> userUpdateHistoryList = new ArrayList<>();

    public void save(UserUpdateHistory userUpdateHistory) {
        userUpdateHistoryList.add(userUpdateHistory);
    }

    public List<UserUpdateHistory> findAllUserUpdateHistory() {
        return userUpdateHistoryList;
    }
}
