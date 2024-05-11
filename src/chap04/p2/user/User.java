package chap04.p2.user;


import chap04.p2.book.Book;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String userId;
    protected String name;
    protected List<Book> borrowedBookList;
    protected UserType userType;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBookList = new ArrayList<>();
    }

    public List<Book> getBorrowedBookList() {
        return borrowedBookList;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getName() {
        return name;
    }
}
