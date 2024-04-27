package chap02;

public class RoadToBiodome01 {

    public static void main(String[] args) {
        int[] waves = new int[1001];
        StringBuilder stringBuilder = new StringBuilder();
        String[] input = args[0].replaceAll(",", "").split(" ");
        for (String str : input) {
            stringBuilder.append(str).append(" ");
            // 입력값이 올바르지 않은 경우 사용자에게 안내 메시지를 출력한다.
            if (!isDigit(str)) {
                System.out.println("숫자만 입력해주세요");
                return;
            }

            int argNumber = Integer.parseInt(str);

            // 입력값이 범위를 벗어나는 경우에 대한 예외 처리를 구현한다.
            if (isAvailableNumber((argNumber))) {
                waves[argNumber]++;
            } else {
                System.out.println("입력된 값의 범위가 올바르지 않습니다. 0에서 1000까지의 값을 입력해주세요.");
                return;
            }
        }
        int result = 0;

        // 주어진 배열에서 한 번만 등장하는 숫자를 찾아 출력한다.
        // Bonus
        // 각 요소가 4번씩 반복되는 것이 아니라 k 번씩 반복되고, 하나의 요소만 1번 등장할 때 사용할 수 있는 일반화된 기능을 구현한다
        for (int i = 0; i < waves.length; i++) {
            if (waves[i] == 1) {
                result = i;
                break;
            }
        }

        System.out.println("입력 : " + stringBuilder.toString().trim());
        System.out.println("결과 : " + result);
    }

    // 파동수의 최소값은 0이며 최대값은 1000이다.
    private static boolean isAvailableNumber(int number) {
        if (number < 0 || number > 1000) {
            return false;
        }
        return true;
    }

    private static boolean isDigit(String input) {
        for (char number : input.toCharArray()) {
            if (!('0' <= number && number <= '9')) {
                return false;
            }
        }
        return true;
    }
}
