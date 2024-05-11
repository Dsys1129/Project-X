package chap04.p2.book;

public class Book {
    private String title;
    private String isbn;
    private String author;
    private boolean isBorrowed;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public void updateBorrowed(boolean borrowed) {
        this.isBorrowed = borrowed;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void displayInfo() {
        String borrowedStr = isBorrowed == true ? "대출 불가" : "대출 가능";
        System.out.println(this.title + ", " + this.isbn + ", " + this.author + ", " + borrowedStr);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

