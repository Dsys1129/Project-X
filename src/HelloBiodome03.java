public class HelloBiodome03 {
    public static void main(String[] args) {
        if (args.length < 3 || args.length > 3) {
            System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");
            return;
        }

        for (String input : args) {
            if (!isNumber(input)) {
                System.out.println("입력된 값이 올바르지 않습니다. [온도][습도][산소농도] 순서 대로 숫자 값을 입력해주세요");
                return;
            }
        }
        double temperature = Double.parseDouble(args[0]);
        double humidity = Double.parseDouble(args[1]);
        double oxygen = Double.parseDouble(args[2]);
        double H = Calculator.calculateH(temperature, humidity, oxygen);

        // 소수 셋째자리에서 반올림하여 출력
        System.out.println("생명지수 H = " + String.format("%.2f", H));
    }

    private static boolean isNumber(String input) {
        return input != null && input.matches("[-+]?\\d*\\.?\\d");
    }

    /**
     * 생명 지수를 계산하는 책임이 있는 Calculator 클래스
     */
    public static class Calculator {
        private static final double B = 0.415;

        // √습도와 온도를 입력 받아 절대값을 계산하고 결과를 반환하는 수식을 메서드로 구현한다.
        private static double calculateAbsoluteDifference(double humidity, double temperature) {
            return CustomMath.abs(sqrt(humidity) - temperature);
        }

        // 생명나무의 생명지수를 계산하는 수식을 메서드로 구현한다.
        // 외부에 공개될 API
        public static double calculateH(double temperature, double humidity, double oxygen) {
            return B * calculateAbsoluteDifference(humidity, temperature) + (oxygen / CustomMath.pow(CustomMath.PI));
        }
    }

    /**
     * Calcuator가 수식 계산을 위해 필요한 연산들을 구현한 Util Class
     */
    private static class CustomMath {
        public static final double PI = 3.14;

        public static double pow(double number) {
            return number * number;
        }

        public static double abs(double number) {
            if (number >= 0) {
                return number;
            }
            return -number;
        }
    }

    // 습도값을 인자로 입력 받아 루트 계산 결과를 반환하는 수식(√)을 메서드로 구현한다.
    // 뉴턴랩슨법
    private static double sqrt(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("값이 음수여서는 안됩니다.");
        }

        double guess = number;
        double epsilon = 1e-6;

        while (true) {
            double nextGuess = 0.5 * (guess + number / guess);
            double absNumber = CustomMath.abs(nextGuess - guess);
            if (absNumber < epsilon) {
                return nextGuess;
            }
            guess = nextGuess;
        }
    }
}
