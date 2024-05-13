package chap04.p7;

import java.time.LocalDateTime;

// TODO 기본, 보너스 완료
public class RuleOfBiodome07 {
    public static void main(String[] args) {
        Plant plant1 = new Plant("백합", "백합", 100, 15, LocalDateTime.of(2130, 03, 12, 12, 00 ,00), 10);
        Plant plant2 = new Plant("나무딸기", "나무딸기", 200, 20, LocalDateTime.of(2130, 03, 12, 14, 20 ,00), 5);
        Plant plant3 = new Plant("선인장", "선인장", 5, 30, LocalDateTime.of(2130, 03, 12, 9, 00 ,00), 10);
        Plant plant4 = new Plant("라일락", "라일락", 20, 25, LocalDateTime.of(2130, 03, 12, 11, 00 ,00), 5);
        Plant plant5 = new Plant("대나무", "대나무", 15, 50, LocalDateTime.of(2130, 03, 12, 19, 00 ,00), 1);

        System.out.println();
        PlantManagerSystem plantManagerSystem = new PlantManagerSystem(5);
        plantManagerSystem.addPlant(plant1);
        plantManagerSystem.addPlant(plant2);
        plantManagerSystem.addPlant(plant3);
        plantManagerSystem.addPlant(plant4);
        plantManagerSystem.addPlant(plant5);

        System.out.println();
        plantManagerSystem.wateringPlant();

        System.out.println();

        plantManagerSystem.wateringPlant();

        System.out.println();
        plantManagerSystem.wateringPlant();

        System.out.println();
        plantManagerSystem.printAllPlants();
    }
}
