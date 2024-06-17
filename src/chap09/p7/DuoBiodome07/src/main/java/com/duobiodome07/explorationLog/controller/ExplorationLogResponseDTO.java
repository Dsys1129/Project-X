package com.duobiodome07.explorationLog.controller;

import com.duobiodome07.explorationLog.ExplorationLog;
import lombok.Getter;

@Getter
public class ExplorationLogResponseDTO {
    private Long id;
    private String title;
    private String body;
    private String createdBy;

    public ExplorationLogResponseDTO(ExplorationLog explorationLog) {
        this.id = explorationLog.getId();
        this.title = explorationLog.getTitle();
        this.body = explorationLog.getBody();
        this.createdBy = explorationLog.getCreatedBy();
    }
}
