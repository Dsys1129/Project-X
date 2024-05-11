package chap04.p1.code;


class Member extends User {
    public Member(String userId, String name) {
        super(userId, name);
    }

    // ISP 위배
    // 사용하지 않는 인터페이스를 구현하도록 강제된다.
    public void addBook(Book book, Library library) {
        System.out.println("Member can't add book");
    }
    public void removeBook(Book book, Library library) {
        System.out.println("Member can't remove book");
    }
}