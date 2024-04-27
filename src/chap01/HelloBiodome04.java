package chap01;

public class HelloBiodome04 {

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
        System.out.println(temperature + " " + humidity + " " + oxygen);

        if (!Validator.validateTemperate(temperature)) {
            System.out.println("온도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");

        } else if (!Validator.validateHumidity(humidity)) {
            System.out.println("습도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");

        } else if (!Validator.validateOxygen(oxygen)) {
            System.out.println("산소값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
        } else {
            double H = Calculator.calculateH(temperature, humidity, oxygen);
            System.out.println("생명의 나무는 안정적인 상태입니다 :)");
            System.out.println("보너스 문제 -> 생명의 나무는 안정적인 상태입니다. 건강 지수는 " + String.format("%.2f", H) + "입니다.");
        }
    }

    private static boolean isNumber(String input) {
        return input != null && input.matches("[-+]?\\d*\\.?\\d");
    }

    private static class Validator {
        private static final int AVAILABLE_MIN_TEMPERATE = 10;
        private static final double AVAILABLE_MAX_TEMPERATE = 27.5;
        private static final int AVAILABLE_MIN_HUMIDITY = 40;
        private static final int AVAILABLE_MAX_HUMIDITY = 60;
        private static final double AVAILABLE_MIN_OXYGEN = 19.5;
        private static final double AVAILABLE_MAX_OXYGEN = 23.5;

        // 온도 10도 이상 27.5도 미만
        public static boolean validateTemperate(double temperate) {
            if (temperate >= AVAILABLE_MIN_TEMPERATE && temperate < AVAILABLE_MAX_TEMPERATE) {
                return true;
            }
            return false;
        }

        // 습도 : 40% 초과 60% 미만
        public static boolean validateHumidity(double humidity) {
            if (humidity > AVAILABLE_MIN_HUMIDITY && humidity < AVAILABLE_MAX_HUMIDITY) {
                return true;
            }
            return false;
        }

        // 산소 농도 19.5% 이상 23.5% 이하
        public static boolean validateOxygen(double oxygen) {
            if (oxygen >= AVAILABLE_MIN_OXYGEN && oxygen <= AVAILABLE_MAX_OXYGEN) {
                return true;
            }
            return false;
        }
    }

    /**
     * 생명 지수를 계산하는 책임이 있는 Calculator 클래스
     */
    public static class Calculator {
        private static final double BIONETY_CONSTANT = 0.415;

        private static double calculateAbsoluteDifference(double humidity, double temperature) {
            return CustomMath.abs(CustomMath.sqrt(humidity, humidity) - temperature);
        }

        private static double calculateH(double temperature, double humidity, double oxygen) {
            return BIONETY_CONSTANT * calculateAbsoluteDifference(humidity, temperature) + (oxygen / CustomMath.pow(CustomMath.PI));
        }
    }

    /**
     * Calcuator가 수식 계산을 위해 필요한 연산들을 구현한 Util Class
     */
    private static class CustomMath {
        public static final double PI = 3.14;
        public static final double EPSILON = 1e-10;

        public static double pow(double number) {
            return number * number;
        }

        public static double abs(double number) {
            if (number >= 0) {
                return number;
            }
            return -number;
        }

        // 반복문 사용 금지 재귀 사용
        public static double sqrt(double number, double guess) {
            double nextGuess = 0.5 * (guess + number / guess);
            double absNumber = abs(nextGuess - guess);
            if (absNumber < EPSILON) {
                return nextGuess;
            }

            nextGuess = 0.5 * (guess + number / guess);
            guess = nextGuess;
            return sqrt(number, guess);
        }
    }
}
