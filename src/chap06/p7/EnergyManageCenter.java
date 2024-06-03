package chap06.p7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnergyManageCenter {
    private static EnergyManageCenter energyManageCenter;
    private List<City> cityList;

    private int energy = 5000;

    private EnergyManageCenter() {
        City terraNova = new City("TerraNova");
        City luminaBay = new City("LuminaBay");
        City flowBridges = new City("FlowBridges");
        cityList = List.of(terraNova, luminaBay, flowBridges);
    }

    public static EnergyManageCenter getInstance() {
        if (energyManageCenter == null) {
            energyManageCenter = new EnergyManageCenter();
        }
        return energyManageCenter;
    }

    public void assignEnergy(String cityName, int energy) {
        if (energy > this.energy) {
            System.out.println("요청된 에너지가 중앙 센터의 보유 에너지보다 많습니다.");
            return;
        }

        if (energy < 0) {
            System.out.println("요청된 에너지가 마이너스 값입니다. 다시 입력해주세요.");
            return;
        }

        for (City city : cityList) {
            if (city.getName().equals(cityName)) {
                city.requestEnergy(energy);
                break;
            }
        }
        this.energy -= energy;
        System.out.println("- 중앙 에너지 센터: " + this.energy);
    }

    public void showAllCitiesEnergy() {
        this.displayInfo();
        for (City city : cityList) {
            city.displayEnergyAmount();
        }
    }

    public void replenishEnergy(int replenishedEnergy) {
        if (replenishedEnergy < 0) {
            System.out.println("보충할 에너지는 양수 값이어야 합니다. 다시 입력해주세요.");
            return;
        }

        this.energy += replenishedEnergy;
        System.out.println("- 중앙 에너지 센터: " + this.energy);

        List<City> sortedCities = new ArrayList<>(cityList);
        Collections.sort(sortedCities, Comparator.comparingInt(City::getEnergy));

        sortedCities.get(0).notifyEnergyReplenishment(replenishedEnergy);
        sortedCities.get(1).notifyEnergyReplenishment(replenishedEnergy);

        if (sortedCities.get(2).getEnergy() == sortedCities.get(0).getEnergy()) {
            sortedCities.get(2).notifyEnergyReplenishment(replenishedEnergy);
        }
    }

    private void displayInfo() {
        System.out.println(" - 중앙 에너지 센터 : " + this.energy);
    }
}
