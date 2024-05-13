package chap04.p8;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Book implements Comparable<Book> {

    private String title;
    private String author;
    private String publishDate;
    private boolean available;
    private LocalDateTime lastBorrowDate;

    public Book(String title, String author, String publishDate, boolean available) {
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        this.available = available;
        printBookInfo();
    }

    public Book(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Book o) {
        return this.title.compareTo(o.title);
    }

    public static Comparator<Book> authorComparator = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.author.compareTo(book2.author);
        }
    };

    public static Comparator<Book> publishDateComparator = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.publishDate.compareTo(book2.publishDate);
        }
    };

    public static Comparator<Book> lastBorrowDateComparator = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {
            return book1.lastBorrowDate.compareTo(book2.lastBorrowDate);
        }
    };

    public static Comparator<Book> titleLengthComparator = new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            if (o1.title.length() == o2.title.length()) {
                return o1.title.compareTo(o2.title);
            }
            return o1.title.length() - o2.title.length();
        }
    };

        public void updateLastBorrowDate(LocalDateTime borrowDate) {
            this.lastBorrowDate = borrowDate;
        }

        public void updateAvailable(boolean available) {
            this.available = available;
        }

        public String getTitle() {
            return title;
        }

        public boolean isAvailable() {
            return available;
        }

        public void printBookInfo() {
            String availability = available ? "가능" : "불가능";
            String lastBorrowDateStr = lastBorrowDate != null ? lastBorrowDate.toString() : "N/A";
            System.out.println("제목: \"" + title + "\", 저자: \"" + author + "\", 출판일: \"" + publishDate + "\", 대출 가능 여부: \"" + availability + "\", 최근 대출 날짜: \"" + lastBorrowDateStr + "\"");
        }

        public LocalDateTime getLastBorrowDate() {
            return lastBorrowDate;
        }
}
