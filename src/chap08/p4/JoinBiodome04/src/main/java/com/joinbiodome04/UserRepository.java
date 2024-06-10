package com.joinbiodome04;

import com.joinbiodome04.user.Interest;
import com.joinbiodome04.user.Team;
import com.joinbiodome04.user.User;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserRepository {
    private HashMap<Long, User> userMap = new HashMap<>();

    public UserRepository() {
        init();
    }

    private void init() {
        userMap.put(1L, new User("name1", Interest.BALLET, Team.BERRYMASTERS));
        userMap.put(2L, new User("name2", Interest.BALLET, Team.SPRINGWATT));
        userMap.put(3L, new User("name3", Interest.MUSIC, Team.SPRINGWATT));
    }

    public List<Team> findLeastActiveTeam() {
        Map<Team, Long> teamActiveLevel = userMap.values().stream().map(User::getTeam)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long minActivityCount = teamActiveLevel.values().stream()
                .min(Long::compare)
                .orElse(Long.MAX_VALUE);

        List<Team> result = teamActiveLevel.entrySet().stream()
                .filter(entry -> entry.getValue().equals(minActivityCount))
                .map(Map.Entry::getKey)
                .sorted(Comparator.comparing(Team::name))
                .collect(Collectors.toList());

        return result;
    }

    public List<Interest> findPopularInterest() {
        Map<Interest, Long> interestMap = userMap.values().stream().map(User::getInterest)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long maxInterestCount = interestMap.values().stream().max(Long::compare)
                .orElse(Long.MIN_VALUE);

        List<Interest> result = interestMap.entrySet().stream()
                .filter(entry -> entry.getValue().equals(maxInterestCount))
                .map(Map.Entry::getKey)
                .sorted(Comparator.comparing(Interest::name))
                .collect(Collectors.toList());
        return result;
    }

    public User findRecentCreatedUser() {
        return userMap.values().stream().max(Comparator.comparing(User::getCreatedDate))
                .orElse(null);
    }
}
