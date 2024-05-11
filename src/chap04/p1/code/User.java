package chap04.p1.code;

import chap04.p1.code.Book;
import chap04.p1.code.Library;

abstract class User {
    public String userId;
    public String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    // SRP 위배
    // User가 회원뿐 아니라 Book을 관리하는 책임도 가진다.
    public void borrowBook(Book book) {
        if(!book.isBorrowed) {
            book.isBorrowed = true;
        }
    }

    public void returnBook(Book book) {
        if(book.isBorrowed) {
            book.isBorrowed = false;
        }
    }

    abstract void addBook(Book book, Library library);
    abstract void removeBook(Book book, Library library);

}
