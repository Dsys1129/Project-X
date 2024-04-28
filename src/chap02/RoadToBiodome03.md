# 3번 문제
* 신윤상

## 목차
### 시간 복잡도의 정의와 필요성
- 시간 복잡도는 특정한 크기의 입력에 대하여 알고리즘이 얼마나 오래 걸리는지를 의미하며, 알고리즘을 위해 필요한 연산의 횟수 또한 의미합니다.
- 소프트 웨어 개발은 주어진 문제를 해결하는 작업입니다. 그런데 어떠한 문제의 답을 계산하는 방법은 한 가지가 아닐 수 있다. 시간복잡도는 다양한 풀이법(알고리즘) 중에 어느 것이 더 효율적인지를 판별하기 위해 필요하다.

### Big O 표기법의 개념과 상황별 예시
- Big O 표기법이란 최악의 경우 알고리즘 수행 시간을 나타냅니다.
- O(1) - 상수 시간 : 해당 알고리즘이 최악의 경우에도 일정한 상수 시간내에 종료된다는 의미입니다. (ex. 해시테이블)
- O(N) - 선형 시간 : 최악의 경우 입력값 n만큼의 연산 횟수를 요구합니다. (ex. 선형탐색)
- O(log N) - 로그 시간 : 최악의 경우 연산 횟수가 log(N)에 비례해서 증가합니다. (ex 이진 탐색)
- O(N log N) - 최악의 경우 연산 횟수가 N log(N)에 비례해서 늘어납니다. (ex. 퀵 정렬)
- O(N^2) - 최악의 경우 연산 횟수가 N에 대한 제곱으로 늘어납니다. (ex. 버블 정렬, 삽입 정렬)
- O(2^N) - 최악의 경우 연산 횟수가 최대 2의 N 제곱만큼 늘어납니다.

### 문제01 코드의 시간 복잡도 분석
```
          for (String str : input) {
            stringBuilder.append(str).append(" ");
            // 입력값이 올바르지 않은 경우 사용자에게 안내 메시지를 출력한다.
            if (!isDigit(str)) {
                System.out.println("숫자만 입력해주세요");
                return;
            }
            
          private static boolean isDigit(String input) {
        for (char number : input.toCharArray()) {
            if (!('0' <= number && number <= '9')) {
                return false;
            }
        }
        return true;
    }
 ```
 - 입력값을 검증하는 코드입니다. 외부 for 문에서 입력값 만큼 O(N)이고, 내부 for문에 O(M)이 중첩된 형태라 시간 복잡도는 O(N * M)로 계산 할 수 있습니다.
```
         // 주어진 배열에서 한 번만 등장하는 숫자를 찾아 출력한다.
        // 각 요소가 4번씩 반복되는 것이 아니라 k 번씩 반복되고, 하나의 요소만 1번 등장할 때 사용할 수 있는 일반화된 기능을 구현한다
        for (int i = 0; i < waves.length; i++) {
            if (waves[i] == 1) {
                result = i;
                break;
            }
        }
```
 - 입력 받은 파동수들 중 1번만 등장하는 파동 수를 찾는 로직입니다. 배열의 길이만큼 선형탐색하므로 O(N)이다.

### 문제02 코드의 시간 복잡도 분석
```
    private static boolean isPalindrome(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
```
- 문자열이 회문인지 검사하는 로직입니다. 문자열의 길이 N / 2 만큼 연산이 수행되지만 상수는 무시하므로 시간 복잡도는 O(N)입니다.
```
        //구현한 스택에 문자열의 각 문자를 하나씩 푸시(push)한 뒤,
        // 모두 푸시된 상태에서 하나씩 팝(pop)하여 역순된 문자열을 생성한다.
        for (char character : input.toCharArray()) {
            stack.push(character);
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
```
- Stack에 문자를 넣고 꺼내는 로직입니다. 문자 길이 N 만큼 반복되므로 각각의 시간복잡도는 O(N)이다.

### 병목 현상 분석 및 최적화 방안
```
        int[] waves = new int[1001];
        for (int i = 0; i < waves.length; i++) {
            if (waves[i] == 1) {
                result = i;
                break;
            }
        }
```
- 문제 1번의 경우 입력될 수 있는 파동수의 최대값으로 배열을 고정적으로 할당하였지만, 반복문의 반복 횟수를 줄이기 위해 들어온 입력의 최대값으로 동적 할당하도록 개선할 수 있습니다.
```
    int maxValue = getMaxWave(input);
    int[] waves = new int[maxValue + 1];
    
    private static int getMaxWave(String[] input) {
        int max = -1;
        for (int i = 0; i < input.length; i++) {
            int number = Integer.parseInt(input[i]);
            if (max > number) {
                max = number;
            }
        }
        return max;
    }
```
---------------------------------------------------

```
    private static boolean isDigit(String input) {
        for (char number : input.toCharArray()) {
            if (!('0' <= number && number <= '9')) {
                return false;
            }
        }
        return true;
    }
```

- 문자열의 길이만큼 한 문자씩 숫자인지 확인하는 메서드입니다.
```
    String input = "한글";
        try {
            int number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException! 숫자가 아닙니다. 종료");
        }
```
- 문자열을 정수로 변환하는 동시에 문자열이 숫자가 아니라면 NumberFormatException이 발생하는데, 이러한 Exception을 Catch해서 처리하는 방법으로 최적화 할 수 있다.