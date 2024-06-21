package com.duodome9.user.repository;

import com.duodome9.global.exception.custom.UserAlreadyExistException;
import com.duodome9.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.HashMap;

@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public User findById(String userId) {
        String sql = "SELECT * From user where id = ?";
        try {
            User user = jdbcTemplate.queryForObject(sql, User.class, userId);
            return user;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public void save(User user) {
        String sql = "INSERT INTO user (user_id, password) values (?, ?)";
        jdbcTemplate.update(sql, user.getUserId(), user.getPassword());
    }
}
