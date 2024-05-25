package chap05.p7;

public class Environment {
    private String date;
    private String time;
    private String oxygen;
    private String humidity;
    private String temperature;

    public Environment(String date, String time, String oxygen, String humidity, String temperature) {
        this.date = date;
        this.time = time;
        this.oxygen = oxygen;
        this.humidity = humidity;
        this.temperature = temperature;
    }

    public String getEnvironmentInfo() {
        return this.date + " " + this.time + ", " + this.oxygen + ", " + this.humidity + ", " + this.temperature;
    }
}
