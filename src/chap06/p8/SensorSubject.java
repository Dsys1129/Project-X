package chap06.p8;

import java.time.LocalDateTime;

public interface SensorSubject {

    void registerObserver(SensorObserver elephantSensor);
    void removeObserver(SensorObserver elephantSensor);
    void notifyObserver(LocalDateTime localDateTime);
}
