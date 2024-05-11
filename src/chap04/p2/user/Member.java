package chap04.p2.user;

import chap04.p2.book.Book;
import chap04.p2.book.TextBook;

public class Member extends User implements BookBorrowable {
    public Member(String userId, String name) {
        super(userId, name);
        this.userType = UserType.MEMBER;
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
    }
}