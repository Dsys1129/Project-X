package chap05.p5;

public class EnvironmentDataAnalyzer {

    private static double BIONETY_CONSTANT = 0.415;

    public static double calculateH(Environment environment) {
        return BIONETY_CONSTANT * calculateAbsoluteDifference(environment) + (Double.parseDouble(environment.getOxygen()) / Math.pow(Math.PI, 2));
    }

    public static double calculateLogAvg(Environment environment) {
        return (Math.log10(Double.parseDouble(environment.getOxygen())) + Math.log10(Double.parseDouble(environment.getHumidity()))) / 2;
    }

    private static double calculateAbsoluteDifference(Environment environment) {
        return Math.abs(Math.sqrt(Double.parseDouble(environment.getHumidity())) -
                Double.parseDouble(environment.getTemperature()));
    }
}
