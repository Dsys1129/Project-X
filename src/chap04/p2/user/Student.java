package chap04.p2.user;


import chap04.p2.book.Book;
import chap04.p2.book.Magazine;
import chap04.p2.book.TextBook;

public class Student extends User implements BookBorrowable {

    public Student(String userId, String name) {
        super(userId, name);
        this.userType = UserType.STUDENT;
    }

    @Override
    public void borrowBook(Book book) {
        if (!(book instanceof Magazine)) {
            if (!book.isBorrowed()) {
                book.updateBorrowed(true);
                borrowedBookList.add(book);
                System.out.println("이용자 \'" + this.name + "\' \'" + book.getTitle() + "\' 대출합니다.");
            } else {
                System.out.println("'" + book.getTitle() + "'은 대출 중입니다.");
            }
        } else {
            System.out.println("학생은 잡지를 대출할 수 없습니다.");
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
        System.out.println("학생 \'" + this.name + "\' \'" + book.getTitle() + "\' 반납합니다.");
    }
}
