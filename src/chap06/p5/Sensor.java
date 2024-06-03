package chap06.p5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Sensor extends Thread {

    private String type;
    private double minValue;
    private double maxValue;
    private double currentValue;
    private long monitoringInterval;
    private boolean warning;

    public Sensor(String type, double minValue, double maxValue) {
        this.type = type;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.monitoringInterval = 5000;
        this.warning = false;
    }

    private double generateData() {
        Random rand = new Random();
        return minValue + (maxValue - minValue) * rand.nextDouble() * 1.5;
    }

    private void checkThreshold() {
        if (currentValue < minValue || currentValue > maxValue) {
            warning = true;
            monitoringInterval = 1000;
        } else {
            warning = false;
            monitoringInterval = 5000;
        }
    }

    @Override
    public void run() {
        while (true) {
            currentValue = generateData();
            checkThreshold();
            displayValue();
            try {
                Thread.sleep(monitoringInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayValue() {
        if (warning) {
            System.out.printf("%s %s: %.1f%% [경고: %s %s]\n",
                    formatLocalDateTime(LocalDateTime.now()), this.type, this.currentValue,
                    this.type, (currentValue < minValue ? "하한 미달" : "상한 초과"));
        } else {
            System.out.println(formatLocalDateTime(LocalDateTime.now())
                    + " " + this.type + " : " + String.format("%.1f", currentValue));
        }
    }

    private String formatLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy년 M월 d일 HH시 mm분 ss초"));
    }
}
