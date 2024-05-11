# SOLID
* 신윤상

### 목차
* SOLID란?
    - 단일 책임원칙(SRP), 개방 폐쇄 원칙(OCP), 리스코프 치환 원칙(LSP), 인터페이스 분리 원칙(ISP), 의존 역전 원칙(DIP)의 첫 글자들을 따서 일컫는 용어이다.
    - 객체지향 프로그래밍에서 소프트웨어 설계의 기본이 되는 5가지 원칙이며, 소프트웨어의 유지보수성, 확장성, 재사용성을 높이고 복잡성을 줄이기 위한 원칙들이다.
* SOLID 원칙의 등장과 필요성
    - 소프트웨어 개발의 복잡성이 증가함에 따라, 코드의 유지보수와 확장성은 매우 중요한 고려사항이 되었다. SOLID 원칙은 이러한 문제를 해결하기 위해 등장했으며, 잘 설계된 소프트웨어 구조를 통해 유연하고 관리하기 쉬운 코드를 작성할 수 있도록 돕는다.
* 다섯가지 원칙 소개
    - SRP (Single Responsibility Principle)
      >"A class or module should have a single responsibility"
      >>클래스와 모듈은 하나의 책임 또는 기능만 가지고 있어야 한다.
        - __하나의 클래스나 모듈이 변경되는 이유는 한가지여야 한다.__
        - 즉, 거대하고 포괄적인 클래스를 설계하는 대신, 작은 단위와 단일 기능을 가진 클래스를 설계해야한다는 것을 의미한다.
        - 클래스에 비즈니스와 관련 없는 기능이 두 개 이상 포함되어 있으면, 책임이 단일하지 않으므로 단일 기능을 가진 여러개의 작은 클래스로 분할되어야한다.
        - 필요성 
          1. 한 책임의 변경으로부터 다른 책임의 변경으로서의 연쇄작용에서 자유로워진다
          2. 책임을 적절히 분배함으로써 코드의 가독성, 유지보수성이 향상된다.
          > 어떤 클래스에 주문 관련 코드와 사용자 관련 코드가 모두 포함되어 있다면 SRP에 위배된다. 
          >> 주문과 사용자는 두 개의 독립적인 비즈니스 도메인 모델이며, 관련이 없는 두 기능을 동일한 클래스에 넣는 것은 단일 책임 원칙에 위배된다. 
          >>> SRP를 충족하기 위해 이 클래스를 더 작게 세분화하여 단일 기능을 가진 두 개의 클래스인 주문 클래스와 사용자 클래스로 분할해야한다.
        - 단일 책임 여부를 결정하기 위해 사용되는 몇가지 결정 원칙
          1. 클래스에 코드, 함수 또는 속성이 너무 많아 코드의 가독성과 유지 보수성에 영향을 미치는 경우 클래스 분할을 고려해야 한다.
          1. 클래스가 너무 과하게 다른 클래스에 의존한다면, 높은 응집도와 낮은 결합도의 코드 설계 사상에 부합하지 않으므로 클래스 분할을 고려해야 하낟.
          2. 클래스에 private 메서드가 너무 많은 경우 이 private 메서드를 새로운 클래스로 분리하고 더 많은 클래스에서 사용할 수 있도록 public 메서드로 설정하여 코드의 재사용성을 향상시켜야 한다.
          3. 클래스의 이름을 비즈니스적으로 명확하게 지정하기 어렵거나 Manager, Context 처럼 일반적인 단어가 아니면 클래스의 이름을 정의하기 어려울 경우, 클래스 책임 정의가 충분히 명확하지 않음을 의미할 수 있다.
          4. 클래스의 많은 메서드가 여러 속성 중 일부에서만 작동하는 경우 이러한 속성과 해당 메서드를 분할하는 것을 고려해야 한다.
        
   - OCP (Open-Closed Principle)
   > "Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification."
    >> 소프트웨어 개체(클래스, 모듈, 함수 등)는 확장에 대해 열려있어야 하며, 변경에 대해서는 닫혀있어야 한다."
   - 새로운 기능을 추가할 때 기존의 모듈, 클래스, 함수를 수정하기 보다는 기존 코드를 기반으로 모듈, 클래스, 함수 등을 추가하는 방식으로 코드를 확장해야 한다는 원칙이다.
   - __구체화에 의존하지 말고 추상화에 의존하라.__
   - 필요성
    1. 시스템의 유연성, 재사용성, 유지보수성을 향상시킨다.
    2. 기존 코드를 변경하는 것은 기존 시스템에 예상치 못한 영향을 줄 수 있으며, 이는 버그를 발생시킬 수 있다. OCP는 이러한 위험을 줄인다.
    3. 확장성이 뛰어난 시스템을 구축할 수 있게 해준다.
    - 구현 방법
      - 변하는 것과 변하지 않을 것을 구분하고 변하는 것을 추상화시켜라.
      - 추상화와 다형성을 이용: 인터페이스나 추상 클래스를 정의하고, 구현 클래스에서 이를 확장하여 사용한다. 새로운 기능이 필요할 때는 이 인터페이스나 추상 클래스를 구현한 새로운 클래스를 만들어 기존 코드의 변경 없이 기능을 확장할 수 있다.
      - 전략 패턴(Strategy Pattern): 행위를 클래스의 집합으로 정의하고, 이들을 동적으로 교체할 수 있게 함으로써 행위를 쉽게 확장할 수 있도록 한다.
      - 데코레이터 패턴(Decorator Pattern): 객체에 추가적인 기능을 동적으로 추가할 수 있도록 하며, 서브클래스 만들기를 통한 확장 대신 사용할 수 있는 방법을 제공한다.
      > 만약 결제 시스템에서 카드 결제 이외에도 PayPal 결제를 지원하고자 할 때, 기존의 결제 모듈을 수정하지 않고 결제 인터페이스를 구현하는 새로운 PayPal 결제 클래스를 추가함으로써 시스템을 확장할 수 있다.
    - LSP
    - >"If S is a subtype of T, then objects of type T may be replaced with objects of type S, without breaking the program."
       >> 만약 S가 T의 하위 유형인 경우, T 유형의 객체는 프로그램을 중단하지 않고도 S 유형의 객체로 대체될 수 있다.
    - >"Functins that use pointers pf references to base classes must be able to use objects of derived classes without knowing it."
       >> "기본 클래스에서 참조 포인터를 사용하는 함수는 특별히 인지하지 않고도 파생 클래스의 객체를 사용할 수 있어야 한다."
      - 즉, 하위 유형 또는 파생 클래스의 객체는 프로그램 내에서 상위 클래스가 나타나는 모든 상황에서 대체 가능하며, 프로그램이 원래 가지는 논리적인 동작이 변경되지 않으며 정확성도 유지된다.
      - 다형성을 지원하기 위한 원칙이다.
      - 상위 클래스를 대체할 때 프로그램의 원래 논리적 동작이 변경되지 않고 프로그램의 정확성이 손상되지 않도록 해야한다는 원칙이다.
      - 하위 클래스를 설계할 때는 상위 클래스의 동작 규칙을 따라야 한다. => 상위 클래스는 함수의 동작 규칙을 정의하고 하위 클래스는 함수의 내부 구현 논리를 변경할 수 있지만, 함수의 원래 동작 규칙은 변경하면 안된다.
      - __즉, 하위 클래스는 상위 클래스의 행동 규약을 위배해서는 안된다.__
    - ISP
    > "Clients should not be forced to depend upon interfaces that they do not use."
     >> 클라이언트는 그들이 사용하지 않는 인터페이스에 의존하면 안된다.
    - 하나의 인터페이스가 너무 많은 메서드를 가지고 있어서, 인터페이스를 구현하는 클래스가 자신과 관련 없는 메서드까지 구현해야하는 경우, 불필요한 의존성을 강요하며 시스템의 유연성을 낮추고 유지보수를 어렵게 만든다.
    - 클라이언트가 실제로 필요로하는 기능만을 제공하는 인터페이스를 통해 시스템의 유연성이 향상된다.
    - 인터페이스가 명확히 분리되어 있으면 변경 사항이 있을 때 다른 부분에 영향을 최소화 할 수 있다.
    - 더 작고 명확한 인터페이스를 통해 코드의 재사용성이 증가한다.
    - 구현 방법
      1. 공통적으로 사용되는 기능들을 작은 인터페이스로 분리하여, 클라이언트가 필요로 하는 기능만을 제공한다.
      2. 시스템 내의 역할을 기준으로 인터페이스를 정의한다. 각 역할에 맞는 인터페이스를 구현함으로써, 더 명확하고 유연한 설계가 가능해진다.
      3. 클라이언트의 요구사항에 맞추어 인터페이스를 구성한다.. 이는 클라이언트가 필요하지 않은 기능에 대한 의존성을 제거하여, 시스템의 결합도를 낮추고 유지보수성을 향상시킨다.

    - DIP
    > "High-level modules should not depend on low-level modules. Both should depend on abstractions. Furthermore, abstractions should not depend on details. Details should depend on abstractions."
     >> "고수준 모듈은 저수준 모듈에 의존해서는 안되며, 둘 다 추상화에 의존해야 한다."
     - 고수준 모듈이 저수준 모듈을 직접 의존하지 않고 추상화를 통해 의존함으로써, 새로운 저수준 모듈을 쉽게 추가하거나 변경할 수 있어 유연성과 확장성이 증가한다.
     - 모듈간의 결합도가 낮아지기 때문에, 재사용성이 증가한다.
     - 코드를 변경할 때, 그 변경이 다른 부분에 미치는 영향을 최소화 할 수 있다.
  - 구현 방법
    1. 고수준 모듈과 저수준 모듈 사이의 의존성을 관리하기 위해 인터페이스 또는 추상 클래스를 정의한다.
    2. 고수준 모듈이 저수준 모듈의 구현체를 직접 생성하지 않고, 외부에서 생성된 구현체를 주입받아 사용한다. 의존성을 외부에서 관리하므로 시스템의 결합도를 낮춘다.


* 도서관 시스템에서 SOLID 원칙에 어긋나는 부분
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
