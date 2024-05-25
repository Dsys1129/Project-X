package chap05.p8;

public class EnvironmentData {
    private String date;
    private String temperature;
    private String humidity;
    private String oxygen;

    public EnvironmentData(String date, String temperature, String humidity, String oxygen) {
        this.date = date;
        this.temperature = temperature;
        this.humidity = humidity;
        this.oxygen = oxygen;
    }

    public String getEnvironmentInfo() {
        return this.date + ", " + this.temperature + ", " + this.humidity + ", " + this.oxygen;
    }

    public String getDate() {
        return date;
    }

    public String getOxygen() {
        return oxygen;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getHumidity() {
        return humidity;
    }
}
