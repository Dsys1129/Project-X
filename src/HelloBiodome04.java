public class HelloBiodome04 {

    public static void main(String[] args) {
        if (args.length < 3) {
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

        if (!Validator.validateTemperate(temperature)) {
            System.out.println("온도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");

        } else if (!Validator.validateHumidity(humidity)) {
            System.out.println("습도값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");

        } else if (!Validator.validateOxygen(oxygen)) {
            System.out.println("산소값이 정상 범위를 벗어났습니다. 확인이 필요합니다.");
        } else {
            double H = HelloBiodome03.Calculator.calculateH(temperature, humidity, oxygen);
            System.out.println("생명의 나무는 안정적인 상태입니다. 건강 지수는 " + String.format("%.2f", H) + "입니다.");
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

        public static boolean validateTemperate(double temperate) {
            if (temperate >= AVAILABLE_MIN_TEMPERATE && temperate < AVAILABLE_MAX_TEMPERATE) {
                return true;
            }
            return false;
        }

        public static boolean validateHumidity(double humidity) {
            if (humidity > AVAILABLE_MIN_HUMIDITY && humidity < AVAILABLE_MAX_HUMIDITY) {
                return true;
            }
            return false;
        }

        public static boolean validateOxygen(double oxygen) {
            if (oxygen >= AVAILABLE_MIN_OXYGEN && oxygen <= AVAILABLE_MAX_OXYGEN) {
                return true;
            }
            return false;
        }
    }
}
