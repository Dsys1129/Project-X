package com.joinbiodome07;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdAt;

    public Post(String title, String writer, String content, LocalDateTime createdAt) {
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
