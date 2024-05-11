package chap04.p2;

import chap04.p2.book.Book;
import chap04.p2.user.User;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        System.out.println("새로운 " + user.getUserType().getDesc() + " \'"  + user.getName() + "\'를 등록합니다.");
        this.users.add(user);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void searchBooksBy(String author) {
        System.out.println("저자 \'" + author + "\'의 책 목록:");
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                book.displayInfo();
            }
        }
    }
}
