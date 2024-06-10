package com.joinbiodome07;

import java.time.LocalDateTime;

public class PostRequest {
    private String title;
    private String writer;
    private String content;

    public Post toEntity() {
        if (title.isEmpty() || writer.isBlank() || content.isBlank()) {
            throw new IllegalArgumentException("제목, 작성자, 내용은 빈값일 수 없습니다.");
        }
        return new Post(this.title, this.writer, this.content, LocalDateTime.now());
    }
}
