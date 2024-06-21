package com.duodome10.explorationLog;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "exploration_log")
public class ExplorationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private String createdBy;

    public ExplorationLog(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public void updateExplorationLog(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
