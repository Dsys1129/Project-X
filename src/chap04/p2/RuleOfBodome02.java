package chap04.p2;

import chap04.p2.book.Book;
import chap04.p2.book.Magazine;
import chap04.p2.book.TextBook;
import chap04.p2.user.Manager;
import chap04.p2.user.Member;
import chap04.p2.user.Student;

public class RuleOfBodome02 {

    public static void main(String[] args) {
        Library library = new Library();

        Manager seiko = new Manager("1", "세이코");
        seiko.setLibrary(library);

        Member mary = new Member("2", "메리");
        Member manok = new Member("3", "만옥");

        library.addUser(seiko);
        library.addUser(mary);
        library.addUser(manok);

        System.out.println();

        seiko.addBook(new Book("1", "자바의 구름", "제임스밥"));
        seiko.addBook(new Book("2", "파이썬 마스터", "한송희"));
        seiko.addBook(new Book("3", "에너지 플로우", "키네틱스"));
        seiko.addBook(new Book("4", "화성에서의 기억", "한송희"));
        seiko.addBook(new Book("5", "야채의 비밀", "송은정"));

        System.out.println();

        mary.borrowBook(library.getBooks().get(0));

        seiko.addBook(new Book("6", "자료구조의 언덕", "황수"));
        seiko.addBook(new Book("7", "그곳에 가면", "한송희"));

        System.out.println();
        manok.borrowBook(library.getBooks().get(0));

        mary.returnBook(mary.getBorrowedBookList().get(0));

        seiko.borrowBook(library.getBooks().get(3));

        System.out.println();
        library.searchBooksBy("한송희");

        System.out.println("=================== Bonus ============");
        Student student = new Student("4", "학생");
        Magazine magazine = new Magazine("8", "학생은 빌릴 수 없는 잡지", "잡지 저자");
        TextBook textBook = new TextBook("9", "학생만 빌릴 수 있는 교과서", "교과서 저자");

        library.addUser(student);
        seiko.addBook(magazine);
        seiko.addBook(textBook);

        System.out.println();

        student.borrowBook(magazine);
        student.borrowBook(textBook);
        student.returnBook(textBook);
        seiko.borrowBook(textBook);
    }
}
