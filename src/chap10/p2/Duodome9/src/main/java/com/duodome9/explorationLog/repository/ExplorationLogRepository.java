package com.duodome9.explorationLog.repository;

import com.duodome9.explorationLog.ExplorationLog;
import com.duodome9.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ExplorationLogRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(ExplorationLog explorationLog) {
        String sql = "INSERT INTO exploration_log(title, body, createdBy) VALUES(?, ?, ?)";

        jdbcTemplate.update(sql, explorationLog.getTitle(), explorationLog.getBody(), explorationLog.getCreatedBy());
    }

    public ExplorationLog findById(Long id) {
        String sql = "SELECT * From exploration_log where id = ?";
        ExplorationLog explorationLog = jdbcTemplate.queryForObject(sql, ExplorationLog.class, id);

        return explorationLog;
    }

    public void update(Long id, String title, String body) {
        String sql = "UPDATE exploration_log SET title = ?, body = ? where id = ?";
        jdbcTemplate.update(sql, title, body, id);
    }

    public List<ExplorationLog> findAll() {
        String sql = "SELECT * FROM exploration_log";
        List<ExplorationLog> explorationLogs = jdbcTemplate.queryForList(sql, ExplorationLog.class);
        return explorationLogs;
    }
}
