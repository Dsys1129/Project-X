package chap02;


public class RoadToBiodome02 {

    public static void main(String[] args) {

        // 메시지가 공백으로만 입력된 경우, 예외 처리를 통해 안내 메시지를 출력한다.
        if (args.length < 1 || args.length > 1 || args[0].isBlank()) {
            System.out.println("올바른 문장을 입력해주세요");
            return;
        }

        // 입력받는 문자열의 길이는 최소 2에서 최대 10^6이다.
        if (args[0].length() < 2 || args[0].length() > 1_000_000) {
            System.out.println("문자열의 길이는 2 ~ 10^6 까지입니다.");
            return;
        }

        String input = args[0];
        System.out.println("입력 : " + input);

        // Bonus
        // 입력받은 문장이 회문(Palindrome)인지 아닌지 검사하고,
        // 회문인 경우 역순 암호화 기능을 수행하지 않고 그대로 출력한다.
        if (isPalindrome(input)) {
            System.out.println("보너스 문제 (Palindrome 맞음) 출력 >> " + input);
            return;
        } else {
            System.out.println("보너스 문제 (Palindrome 아님)");
        }

        CustomStack stack = new CustomStack();
        StringBuffer result = new StringBuffer();

        //구현한 스택에 문자열의 각 문자를 하나씩 푸시(push)한 뒤,
        // 모두 푸시된 상태에서 하나씩 팝(pop)하여 역순된 문자열을 생성한다.
        for (char character : input.toCharArray()) {
            stack.push(character);
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println("출력 : " + result);
    }

    private static boolean isPalindrome(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // Java 기본 제공 Stack을 사용하지 않고 직접 스택 구조를 구현한다.
    // 스택은 Last In First Out (LIFO)의 원칙에 따라 동작해야 한다.
    // 스택을 구현하기 위해 배열이나 리스트를 활용할 수 있다.
    // push(), pop(), peek(),isEmpty()등 기본 스택 연산 중 필요한 기능을 구현한다.
    static class CustomStack {
        private char[] elements;
        private int size;
        private int head;

        public CustomStack() {
            this.head = -1;
            this.size = 0;
            this.elements = new char[1_000_000];
        }

        public boolean isEmpty() {
            if (size == 0) {
                return true;
            }
            return false;
        }

        public void push(char element) {
            if (size == elements.length) {
                throw new IllegalArgumentException("Stack is Full");
            }
            size++;
            elements[++head] = element;
        }

        public char pop() {
            if (isEmpty()) {
                throw new IllegalArgumentException("Stack is Empty");
            }
            size--;
            return elements[head--];
        }
    }
}
