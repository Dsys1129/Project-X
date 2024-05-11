package chap04.p2.user;


import chap04.p2.book.Book;

public interface BookBorrowable {

    void borrowBook(Book book);
    void returnBook(Book book);
}
