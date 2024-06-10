package com.joinbiodome08;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

public class PostManager {

    private static Long idx = 1L;
    private ConcurrentHashMap<Long, Post> postMap = new ConcurrentHashMap<>();

    public PostManager() {
        postMap.put(0L, new Post("user2", "content2", LocalDateTime.now()));
    }

    public void save(Post post) {
        post.setId(idx);
        postMap.put(idx++, post);
    }

    public Post findPostBy(Long postId) {
        Post post = postMap.get(postId);
        if (post == null) {
            throw new IllegalArgumentException("해당하는 포스트가 없습니다.");
        }
        return post;
    }

//    public List<String> findAllPostTitleOrderByCreatedAtASC() {
//        return this.postMap.values().stream().sorted((o1, o2) ->
//                o2.getCreatedAt().compareTo(o1.getCreatedAt()))
//                .map(Post::getTitle).collect(Collectors.toList());
//    }

    public void removePost(Long postId) {
        Post deletePost = postMap.get(postId);
        if (deletePost == null) {
            throw new IllegalArgumentException("해당하는 포스트가 없습니다.");
        }
        postMap.remove(deletePost);
        idx--;
    }

    public void rollback(Transaction transaction) {
        if (transaction.getTransactionType().equals("CREATE")) {
            postMap.remove(--idx);
            return;
        } else if (transaction.getTransactionType().equals("DELETE")) {
            save(transaction.getPost());
        }
    }
}
