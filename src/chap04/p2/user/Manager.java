package chap04.p2.user;


import chap04.p2.Library;
import chap04.p2.book.Book;
import chap04.p2.book.TextBook;

public class Manager extends User implements BookBorrowable, BookManageable {

    private Library library;

    public Manager(String userId, String name) {
        super(userId, name);
        this.userType = UserType.MANAGER;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public void borrowBook(Book book) {
        if (!(book instanceof TextBook)) {
            if (!book.isBorrowed()) {
                book.updateBorrowed(true);
                borrowedBookList.add(book);
                System.out.println("이용자 \'" + this.name + "\' \'" + book.getTitle() + "\' 대출합니다.");
            } else {
                System.out.println("'" + book.getTitle() + "'은 대출 중입니다.");
            }
        } else {
            System.out.println("교과서는 학생만 대출할 수 있습니다.");
        }
    }

    @Override
    public void returnBook(Book book) {
        if (!book.isBorrowed()) {
            System.out.println(book.getTitle() + "은 대출 중이 아닙니다.");
            return;
        }
        book.updateBorrowed(false);
        borrowedBookList.remove(book);
        System.out.println("관리자 \'" + this.name + "\' \'" + book.getTitle() + "\' 반납합니다.");

    }

    @Override
    public void addBook(Book book) {
        System.out.println("관리자 \'" + this.name + "\'가 " + book.getTitle() +"를 등록했습니다.");
        this.library.addBook(book);
    }

    @Override
    public void removeBook(Book book) {
        if (book.isBorrowed()) {
            System.out.println("대출 중인 책은 삭제할 수 없습니다.");
            return;
        }
        System.out.println("관리자 \'" + this.name + "\'가 " + book.getTitle() +"를 삭제했습니다..");
        this.library.removeBook(book);
    }
}