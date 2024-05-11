# SOLID 원칙

*작성자: 신윤상*

## 목차
- [SOLID란?](#solid란)
- [SOLID 원칙의 등장과 필요성](#solid-원칙의-등장과-필요성)
- [다섯 가지 원칙 소개](#다섯-가지-원칙-소개)
    - [SRP (Single Responsibility Principle)](#srp-single-responsibility-principle)
    - [OCP (Open-Closed Principle)](#ocp-open-closed-principle)
    - [LSP (Liskov Substitution Principle)](#lsp-liskov-substitution-principle)
    - [ISP (Interface Segregation Principle)](#isp-interface-segregation-principle)
    - [DIP (Dependency Inversion Principle)](#dip-dependency-inversion-principle)
- [도서관 시스템에서 SOLID 원칙에 어긋나는 부분](#도서관-시스템에서-solid-원칙에-어긋나는-부분)

## SOLID란?
SOLID는 객체지향 프로그래밍과 소프트웨어 설계의 다섯 가지 기본 원칙을 나타내는 약자로, **단일 책임 원칙(SRP)**, **개방 폐쇄 원칙(OCP)**, **리스코프 치환 원칙(LSP)**, **인터페이스 분리 원칙(ISP)**, **의존 역전 원칙(DIP)**의 첫 글자들을 따서 만들어졌습니다. 이 원칙들은 소프트웨어의 유지보수성, 확장성, 재사용성을 높이고 복잡성을 줄이는 데 목적을 두고 있습니다.

## SOLID 원칙의 등장과 필요성
소프트웨어 개발의 복잡성이 증가함에 따라, 코드의 유지보수와 확장성은 매우 중요한 고려사항이 되었습니다. SOLID 원칙은 이러한 문제를 해결하기 위해 등장했으며, 잘 설계된 소프트웨어 구조를 통해 유연하고 관리하기 쉬운 코드를 작성할 수 있도록 돕습니다.

## 다섯 가지 원칙 소개

### SRP (Single Responsibility Principle)
>"A class or module should have a single responsibility"

클래스와 모듈은 하나의 책임 또는 기능만 가지고 있어야 합니다. 하나의 클래스나 모듈이 변경되는 이유는 한 가지여야 하며, 이는 거대하고 포괄적인 클래스를 설계하는 대신, 작은 단위와 단일 기능을 가진 클래스를 설계해야 한다는 것을 의미합니다.

#### 필요성
1. 한 책임의 변경으로부터 다른 책임의 변경으로서의 연쇄작용에서 자유로워진다.
2. 책임을 적절히 분배함으로써 코드의 가독성, 유지보수성이 향상된다.

### OCP (Open-Closed Principle)
>"Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification."

소프트웨어 개체(클래스, 모듈, 함수 등)는 확장에 대해 열려있어야 하며, 변경에 대해서는 닫혀있어야 합니다. 이는 새로운 기능을 추가할 때 기존의 모듈, 클래스, 함수를 수정하기 보다는 기존 코드를 기반으로 모듈, 클래스, 함수 등을 추가하는 방식으로 코드를 확장해야 한다는 원칙입니다.

#### 필요성
1. 시스템의 유연성, 재사용성, 유지보수성을 향상시킨다.
2. 기존 코드를 변경하는 것은 기존 시스템에 예상치 못한 영향을 줄 수 있으며, 이는 버그를 발생시킬 수 있다.

### LSP (Liskov Substitution Principle)
>"If S is a subtype of T, then objects of type T may be replaced with objects of type S, without breaking the program."

하위 유형 또는 파생 클래스의 객체는 프로그램 내에서 상위 클래스가 나타나는 모든 상황에서 대체 가능하며, 프로그램이 원래 가지는 논리적인 동작이 변경되지 않으며 정확성도 유지된다는 원칙입니다.

### ISP (Interface Segregation Principle)
>"Clients should not be forced to depend upon interfaces that they do not use."

클라이언트는 그들이 사용하지 않는 인터페이스에 의존하면 안됩니다. 하나의 인터페이스가 너무 많은 메서드를 가지고 있어서, 인터페이스를 구현하는 클래스가 자신과 관련 없는 메서드까지 구현해야하는 경우, 불필요한 의존성을 강요하며 시스템의 유연성을 낮추고 유지보수를 어렵게 만듭니다.

### DIP (Dependency Inversion Principle)
>"High-level modules should not depend on low-level modules. Both should depend on abstractions."

고수준 모듈은 저수준 모듈에 의존해서는 안되며, 둘 다 추상화에 의존해야 합니다. 이는 고수준 모듈이 저수준 모듈을 직접 의존하지 않고 추상화를 통해 의존함으로써, 새로운 저수준 모듈을 쉽게 추가하거나 변경할 수 있어 유연성, 확장성, 유지보수성을 증가시킵니다.

## 도서관 시스템에서 SOLID 원칙에 어긋나는 부분
  * 코드와 이유
  - ISP 위배
```
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
```
- Member가 사용하지 않는 인터페이스를 강제적으로 구현하도록 설계되어있다. 이는 ISP에 위배된다.

  * 코드와 이유
- SRP 위배
 ```
abstract class User {
public String userId;
public String name;

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    // SRP 위배
    // User가 회원뿐 아니라 Book을 관리하는 책임도 가진다.
    public void borrowBook(Book book) {
        if(!book.isBorrowed) {
            book.isBorrowed = true;
        }
    }

    public void returnBook(Book book) {
        if(book.isBorrowed) {
            book.isBorrowed = false;
        }
    }

    abstract void addBook(Book book, Library library);
    abstract void removeBook(Book book, Library library);

}
```
- User는 회원 정보를 관리하는 것 뿐만 아니라, Book을 관리하는 책임도 가진다. SRP 위배
- 
  * 코드와 이유
- OCP 위배
```
class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public Book writeBook(String isbn, String title, String author) {
        Book book = new Book(isbn, title, author);
        books.add(book);
        return book;
    }
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    // OCP 위배
    // 새로운 User Type이 추가된다면 Library가 수정되어야 한다.
    public void addMember(Member member) {
        users.add(member);
    }

    public void addManager(Manager manager) {
        users.add(manager);
    }
}
```
- 위의 Library 클래스에서는 새로운 사용자 유형(Member, Manager)을 추가할 때마다 새로운 메서드(addMember, addManager)를 추가해야 한다. 만약 새로운 사용자 유형이 추가된다면, Library 클래스 자체를 수정해야 하므로 OCP를 위배한다.
