package com.duodome9.explorationLog;

import lombok.Getter;

@Getter
public class ExplorationLog {

    private Long id;
    private String title;
    private String body;
    private String createdBy;

    public ExplorationLog(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void updateExplorationLog(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
