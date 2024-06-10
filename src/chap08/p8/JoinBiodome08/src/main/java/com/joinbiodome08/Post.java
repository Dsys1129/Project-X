package com.joinbiodome08;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private String writer;
    private String content;
    private LocalDateTime createdAt;

    public Post(String writer, String content, LocalDateTime createdAt) {
        this.writer = writer;
        this.content = content;
        this.createdAt = createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getWriter() {
        return writer;
    }
}
