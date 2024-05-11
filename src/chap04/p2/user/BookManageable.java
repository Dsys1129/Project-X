package chap04.p2.user;


import chap04.p2.book.Book;

public interface BookManageable {

    void addBook(Book book);
    void removeBook(Book book);
}
