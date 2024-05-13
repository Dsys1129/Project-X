package chap04.p8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

    private List<Book> bookList;

    public Library() {
        this.bookList = new ArrayList<>();
        System.out.println("도서관 시스템이 생성되었습니다.");
    }

    public void addBook(Book book) {
        bookList.add(book);
        System.out.println("\"" + book.getTitle() + "\"가 도서 목록에 추가되었습니다.");
    }

    public void borrowBook(Book book, LocalDateTime borrowDate) {
        for (Book existsbook : bookList) {
            if (existsbook.getTitle().equals(book.getTitle())) {
                if (!existsbook.isAvailable()) {
                    System.out.println("대출 중인 책입니다.");
                    return;
                }

                existsbook.updateLastBorrowDate(borrowDate);
                existsbook.updateAvailable(false);
                System.out.println("\"" + existsbook.getTitle() + "\" 대출되었습니다. 최근 대출 날짜 업데이트 : " +
                        existsbook.getLastBorrowDate());
                return;
            }
        }

        System.out.println("존재하지 않는 책입니다.");
        return;
    }

    public void returnBook(Book book) {
        for (Book existsbook : bookList) {
            if (existsbook.getTitle().equals(book.getTitle())) {
                if (existsbook.isAvailable()) {
                    System.out.println("대출된 책이 아닙니다.");
                    return;
                }

                existsbook.updateAvailable(true);
                System.out.println("\"" + existsbook.getTitle() + "\" 반납되었습니다.");
                return;
            }
        }
        System.out.println("존재하지 않는 책입니다.");
        return;
    }

    public void printAllBooks() {
        System.out.println("(도서 조회 결과)");
        for (Book book : bookList) {
            book.printBookInfo();
        }
    }

    public void printAllBooksOrderByAuthor() {
        List<Book> sortedBookList = new ArrayList<>(bookList);

        Collections.sort(sortedBookList, Book.authorComparator);

        System.out.println("(저자 기반 정렬 조회)");
        for (Book book : sortedBookList) {
            book.printBookInfo();
        }
    }

    public void printAllBooksOrderByPublishDate() {
        List<Book> sortedBookList = new ArrayList<>(bookList);

        Collections.sort(sortedBookList, Book.publishDateComparator);

        System.out.println("(출판일 기반 정렬 조회)");
        for (Book book : sortedBookList) {
            book.printBookInfo();
        }
    }

    public void printAllBooksOrderByTitleLength() {
        List<Book> sortedBookList = new ArrayList<>(bookList);

        Collections.sort(sortedBookList, Book.titleLengthComparator);

        System.out.println("Bonus > (책 제목 길이 기반 정렬 조회)");
        for (Book book : sortedBookList) {
            book.printBookInfo();
        }
    }
}
