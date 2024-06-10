package com.joinbiodome02.user;

import com.joinbiodome02.UserRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserUpdateHistory {
    private Long userId;
    private Map<String, String> beforeValueMap = new HashMap<>();
    private Map<String, String> afterValueMap = new HashMap<>();
    private LocalDateTime updateDate;

    public UserUpdateHistory(User user, UserRequest userRequest, LocalDateTime updateDate) {
        this.userId = user.getId();
        this.updateDate = updateDate;
        setValueMaps(user, userRequest);
    }

    private void setValueMaps(User user, UserRequest userRequest) {
        if (!user.getName().equals(userRequest.getName())) {
            beforeValueMap.put("name", user.getName());
            afterValueMap.put("name", userRequest.getName());
        }
        if (!user.getTeam().name().equals(userRequest.getName())) {
            beforeValueMap.put("team", user.getTeam().name());
            afterValueMap.put("team", userRequest.getTeam());
        }
        if (!user.getEmail().equals(userRequest.getEmail())) {
            beforeValueMap.put("email", user.getEmail());
            afterValueMap.put("email", userRequest.getEmail());
        }
        List<String> userInterests = user.getInterest().stream().map(Enum::name).collect(Collectors.toList());
        List<String> updateInterests = userRequest.getInterests();

        if (!userInterests.equals(updateInterests)) {
            beforeValueMap.put("interest", String.join(", ", userInterests));
            afterValueMap.put("interest", String.join(", ", updateInterests));
        }
    }
}
