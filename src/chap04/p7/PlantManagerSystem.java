package chap04.p7;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PlantManagerSystem {

    private List<Plant> plantList;
    private PlantPriorityQueue plantPriorityQueue;
    private int humidity;

    public PlantManagerSystem(int humidity) {
        plantList = new ArrayList<>();
        plantPriorityQueue = new PlantPriorityQueue();
        this.humidity = humidity;
        System.out.println("식물 관리 시스템이 생성되었습니다.");
    }

    public void addPlant(Plant plant) {
        plantList.add(plant);
        plantPriorityQueue.offer(plant);
        System.out.println(plant.getName() + "이 관리 대상 목록에 추가되었습니다.");
    }

    public void wateringPlant() {
        Plant poll = plantPriorityQueue.poll();
        System.out.print("우선 관리 대상 : ");
        poll.updateLastWaterSupplyDate(LocalDateTime.now());
        poll.displayInfo();
        System.out.println(" 물을 공급했습니다.");
        if (poll.getHumidity() > this.humidity) {
            System.out.println("(Bonus 문제) 오늘의 습도 " + this.humidity + "가 " + poll.getName() + "의 적정 습도 " + poll.getHumidity() + "보다 낮기 때문에 물을 1.5배 늘여서 공급했습니다.");
        }
        plantList.remove(poll);
    }

    public void printAllPlants() {
        System.out.println("남아 있는 식물 출력 : ");
        for (Plant plant : plantList) {
            plant.displayInfo();
        }
    }
}
