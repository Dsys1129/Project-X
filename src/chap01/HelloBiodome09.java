package chap01;

public class HelloBiodome09 {

    public static void main(String[] args) {
        if (!isDigit(args[0])) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }
        int height = Integer.parseInt(args[0]);
        if (!isValidHeight(height)) {
            System.out.println("잘못된 입력입니다. 3~100 사이의 숫자를 입력하세요.");
            return;
        }

        char bonusCharacter = '*';

        if (args.length == 2 && args[1] != null) {
            bonusCharacter = args[1].charAt(0);
        }

        createTree(height, bonusCharacter);
    }

    private static boolean isDigit(String input) {
        for (char number : input.toCharArray()) {
            if (!('0' <= number && number <= '9')) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidHeight(int heigth) {
        if (heigth < 3 || heigth > 100) {
            return false;
        }
        return true;
    }

    private static void createTree(int height, char bonusCharacter) {
        // 나무의 높이
        for (int i = 0; i <= height; i++) {
            // 줄기 출력
            if (i == height) {
                for (int j = 0; j < i - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("|");
            } else {
                // 왼쪽 공백 출력
                for (int j = 0; j < height - i - 1; j++) {
                    System.out.print(" ");
                }
                // 별 및 특수문자 출력
                for (int j = 0; j < 2 * i + 1; j++) {
                    if (j == i) {
                        System.out.print(bonusCharacter);
                    } else {
                        System.out.print("*");
                    }
                }
                System.out.println();
            }
        }
    }
}
