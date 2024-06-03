package chap06.p8;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class CalculationAnalyzer implements SensorObserver, Runnable{

    private List<Double> temperatureList = new ArrayList<>();

    @Override
    public void addData(LocalDateTime localDateTime, double bodyTemperature, int heartRate) {
        this.temperatureList.add(bodyTemperature);
        getAverageBodyTemperature();
        getMaxBodyTemperature();
        getMinBodyTemperature();
    }

    private void getMaxBodyTemperature() {
        Double maxTemperature = temperatureList.stream().max(Double::compareTo).get();
        System.out.println("[분석기 2] 최대 체온 : " + String.format("%.1f", maxTemperature));
    }

    private void getMinBodyTemperature() {
        Double minTemperature = temperatureList.stream().min(Double::compareTo).get();
        System.out.println("[분석기 2] 최소 체온 : " +  String.format("%.1f", minTemperature));
    }

    private void getAverageBodyTemperature() {
        OptionalDouble average = temperatureList.stream().mapToDouble(d -> d).average();
        System.out.println("[분석기 2] 평균 체온 : " + String.format("%.1f", average.getAsDouble()));
    }

    @Override
    public void run() {

    }
}
