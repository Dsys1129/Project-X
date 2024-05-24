package chap05.p4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Environment {
    private String dateTime;
    private String temperature;
    private String humidity;
    private String oxygen;
    private String place;

    public Environment(String temperature, String humidity, String oxygen, String place) {
        this.dateTime = formatDateTime(LocalDateTime.now());
        this.temperature = temperature;
        this.humidity = humidity;
        this.oxygen = oxygen;
        this.place = place;
    }

    private String formatDateTime(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm"));
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getOxygen() {
        return oxygen;
    }

    public String getPlace() {
        return place;
    }

    public String getTemperature() {
        return temperature;
    }
}
