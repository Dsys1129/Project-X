package chap04.p7;

import java.time.LocalDateTime;

public class Plant implements Comparable<Plant> {

    private String name;
    private String type;
    private int requiredWater;
    private int wateringCycle;
    private LocalDateTime lastWateringDate;
    private int humidity;

    public Plant(String name, String type, int requiredWater, int wateringCycle, LocalDateTime lastWateringDate, int humidity) {
        this.name = name;
        this.type = type;
        this.requiredWater = requiredWater;
        this.wateringCycle = wateringCycle;
        this.lastWateringDate = lastWateringDate;
        this.humidity = humidity;
        displayInfo();
    }

    public void updateLastWaterSupplyDate(LocalDateTime localDateTime) {
        this.lastWateringDate = localDateTime;
    }

    public LocalDateTime getNextWateringTime() {
        return this.lastWateringDate.plusHours(wateringCycle);
    }

    public void displayInfo() {
        System.out.println("이름 : " + this.name + ", 종류 : " + this.type + ", 필요한 물의 양 : " + this.requiredWater +
                ", 물 공급 주기 : " + this.wateringCycle + "시간, 마지막 물 공급 일자 : " + this.lastWateringDate + ",적정 습도 : " + this.humidity);
    }

    @Override
    public int compareTo(Plant o) {
        if (this.getNextWateringTime().isBefore(o.getNextWateringTime())) {
            return -1;
        }
        return 1;
    }

    public String getName() {
        return name;
    }

    public int getHumidity() {
        return humidity;
    }
}
