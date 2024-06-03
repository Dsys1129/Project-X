package chap06.p8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DetectorAnalyzer implements SensorObserver, Runnable {

    private static final double MIN_BODY_TEMPERATURE_VALUE = 35.9;
    private static final double MAX_BODY_TEMPERATURE_VALUE = 37.5;
    private static final int MIN_HEART_RATE_VALUE = 25;
    private static final int MAX_HEART_RATE_VALUE = 40;

    private List<Double> invalidTemperatureList = new ArrayList<>();
    private List<Integer> invalidHeartRateList = new ArrayList<>();

    @Override
    public void addData(LocalDateTime localDateTime, double bodyTemperature, int heartRate) {
        if (isInvalidBodyTemperature(bodyTemperature)) {
            invalidTemperatureList.add(bodyTemperature);
            System.out.println("[분석기 1] 임계치 이상 체온 : " + String.format("%.1f", bodyTemperature));
        }
        if (isInvalidHeartRate(heartRate)) {
            invalidHeartRateList.add(heartRate);
            System.out.println("[분석기 1] 임계치 이상 심박수 : " + heartRate);
        }
    }

    private boolean isInvalidBodyTemperature(double bodyTemperature) {
        return bodyTemperature < MIN_BODY_TEMPERATURE_VALUE || bodyTemperature > MAX_BODY_TEMPERATURE_VALUE;
    }

    private boolean isInvalidHeartRate(int heartRate) {
        return heartRate < MIN_HEART_RATE_VALUE || heartRate > MAX_HEART_RATE_VALUE;
    }


    @Override
    public void run() {

    }
}
