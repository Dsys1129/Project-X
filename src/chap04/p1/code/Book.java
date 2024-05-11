package chap04.p1.code;

class Book {
    public String isbn;
    public String title;
    public String author;
    public boolean isBorrowed;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }
}

