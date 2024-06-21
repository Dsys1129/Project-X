package com.duodome10.explorationLog.controller;

import com.duodome10.explorationLog.ExplorationLog;
import lombok.Getter;

@Getter
public class ExplorationLogRequestDTO {
    private String title;
    private String body;

    public ExplorationLog toEntity() {
        return new ExplorationLog(title, body);
    }
}
