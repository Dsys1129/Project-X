package com.duodome08.explorationLog.repository;

import com.duodome08.explorationLog.ExplorationLog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ExplorationLogRepository {

    private HashMap<Long, ExplorationLog> explorationLogHashMap = new HashMap<>();
    private static Long idx = 1L;

    public void save(ExplorationLog explorationLog) {
        explorationLog.setId(idx);
        explorationLogHashMap.put(idx, explorationLog);
        idx++;
    }

    public ExplorationLog findById(Long id) {
        return explorationLogHashMap.get(id);
    }

    public void update(Long id, ExplorationLog explorationLog) {
        explorationLogHashMap.put(id, explorationLog);
    }

    public List<ExplorationLog> findAll() {
        return explorationLogHashMap.values().stream().toList();
    }
}
