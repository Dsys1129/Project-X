package chap04.p1.code;

public class BiodomeFamily08_Before {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = library.writeBook("0001", "Book1", "Author1");
        Book book2 = library.writeBook("0002", "Book2", "Author2");

        Member member = new Member("U001", "Kim");
        Manager manager = new Manager("U002", "Song");

        library.addMember(member);
        library.addManager(manager);

        member.borrowBook(book1);
        System.out.println("Borrow Book1: " + book1.title);
        member.returnBook(book1);
        System.out.println("Return Book1 " + book1.title);
    }
}
