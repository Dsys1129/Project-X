package com.joinbiodome08;

import java.time.LocalDateTime;

public class PostRequest {
    private String writer;
    private String content;

    public Post toEntity() {
        if (writer.isBlank() || content.isBlank()) {
            throw new IllegalArgumentException("제목, 작성자, 내용은 빈값일 수 없습니다.");
        }
        return new Post(this.writer, this.content, LocalDateTime.now());
    }
}
