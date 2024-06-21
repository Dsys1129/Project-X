package com.duodome9.explorationLog.controller;

import com.duodome9.explorationLog.ExplorationLog;
import lombok.Getter;

@Getter
public class ExplorationLogRequestDTO {
    private String title;
    private String body;

    public ExplorationLog toEntity() {
        return new ExplorationLog(title, body);
    }
}
