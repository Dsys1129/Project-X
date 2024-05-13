package chap04.p8;

import java.time.LocalDateTime;

// TODO 기본, 보너스 완료
public class RuleOfBiodoem08 {

    public static void main(String[] args) {
        Book book1 = new Book("파이썬 마스터", "한송희", "2020-01-01", true);
        Book book2 = new Book("자바의 구름", "제임스밥", "2018-05-05", true);
        Book book3 = new Book("에너지 플로우", "키네틱스", "2019-08-15", true);
        Book book4 = new Book("화성에서의 기억", "한송희", "2021-03-03", true);
        Book book5 = new Book("야채의 비밀", "송은정", "2017-10-10", true);

        System.out.println();
        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        System.out.println("\n (대출1)");
        Book wantedBook1 = new Book("야채의 비밀");
        library.borrowBook(wantedBook1, LocalDateTime.now());

        System.out.println("\n (대출2)");
        Book wantedBook2 = new Book("화성에서의 기억");
        library.borrowBook(wantedBook2, LocalDateTime.now());

        System.out.println("\n (반납)");
        library.returnBook(wantedBook1);

        System.out.println();
        library.printAllBooks();

        System.out.println();
        library.printAllBooksOrderByAuthor();

        System.out.println();
        library.printAllBooksOrderByPublishDate();

        System.out.println("\n=============== Bonus ==============");
        Book bonusBook1 = new Book("b", "저자", "2030-9-10", true);
        Book bonusBook2 = new Book("a", "저자", "2030-10-10", true);
        library.addBook(bonusBook1);
        library.addBook(bonusBook2);
        System.out.println();
        library.printAllBooksOrderByTitleLength();
    }
}
