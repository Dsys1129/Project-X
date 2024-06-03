package chap06.p8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElephantSensor implements SensorSubject, Runnable {

    private double bodyTemperature;
    private int heartRate;
    private List<SensorObserver> observers = new ArrayList<>();

    public void measurementsChanged() {
        bodyTemperature = new Random().nextDouble() * 100;
        heartRate = new Random().nextInt(100);
        LocalDateTime now = LocalDateTime.now();
        displayInfo(now);
        notifyObserver(now);
    }

    private void displayInfo(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
        String formattedDateTime = localDateTime.format(formatter);
        System.out.println(formattedDateTime + " 체온 : " +
                String.format("%.1f°C", this.bodyTemperature) + ", 심박수 : " + String.format("%sbpm", this.heartRate));
    }

    @Override
    public void registerObserver(SensorObserver sensorObserver) {
        this.observers.add(sensorObserver);
    }

    @Override
    public void removeObserver(SensorObserver sensorObserver) {
        this.observers.remove(sensorObserver);
    }

    @Override
    public void notifyObserver(LocalDateTime localDateTime) {
        for (SensorObserver observer : observers) {
            observer.addData(localDateTime, this.bodyTemperature, this.heartRate);
        }
    }

    @Override
    public void run() {
        while (true)
        try {
            measurementsChanged();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
