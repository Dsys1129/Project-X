package com.joinbiodome07;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class PostManager {

    private static Long idx = 1L;
    private ConcurrentHashMap<Long, Post> postMap = new ConcurrentHashMap<Long, Post>();

    public void writePost(Post post) {
        post.setId(idx);
        postMap.put(idx++, post);
    }

    public List<String> findAllPostTitleOrderByCreatedAtASC() {
        return this.postMap.values().stream().sorted((o1, o2) ->
                        o2.getCreatedAt().compareTo(o1.getCreatedAt()))
                .map(Post::getTitle).collect(Collectors.toList());
    }
}
