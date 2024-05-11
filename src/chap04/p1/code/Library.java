package chap04.p1.code;

import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public Book writeBook(String isbn, String title, String author) {
        Book book = new Book(isbn, title, author);
        books.add(book);
        return book;
    }
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    // OCP 위배
    // 새로운 User Type이 추가된다면 Library가 수정되어야 한다.
    public void addMember(Member member) {
        users.add(member);
    }

    public void addManager(Manager manager) {
        users.add(manager);
    }
}
