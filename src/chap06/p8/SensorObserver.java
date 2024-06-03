package chap06.p8;

import java.time.LocalDateTime;

public interface SensorObserver {

    void addData(LocalDateTime localDateTime, double bodyTemperature, int heartRate);
}
