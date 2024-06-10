package com.joinbiodome08;

public class Transaction {
    private Post post;
    private String transactionType;

    public Transaction(Post post, String transactionType) {
        this.post = post;
        this.transactionType = transactionType;
    }

    public Post getPost() {
        return post;
    }

    public String getTransactionType() {
        return transactionType;
    }
}
