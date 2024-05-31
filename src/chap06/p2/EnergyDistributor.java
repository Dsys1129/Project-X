package chap06.p2;

import java.util.HashMap;
import java.util.function.Predicate;

public class EnergyDistributor {
    private int totalEnergy = 50000;
    private HashMap<String, Integer> energyMap = new HashMap<>();

    public EnergyDistributor() {
        energyMap.put("테라노바", 0);
        energyMap.put("루미나베이", 0);
        energyMap.put("플로우브릿지", 0);
    }

    public void showTotalEnergy() {
        System.out.println("전체 남은 에너지 : " + totalEnergy);
    }

    public void showPlaceEnergy() {
        System.out.println("구역별 에너지 조회 : ");
        energyMap.forEach((place, energy) ->
                System.out.println(place + " : " + energy));
    }

    public void allocateEnergy(String place, int amount) {
        if (totalEnergy < amount) {
            System.out.println("할당 가능한 에너지를 초과했습니다.");
            return;
        }

        Allocator allocator = (p, a) -> {
            energyMap.put(place, energyMap.getOrDefault(place, 0) + a);
            totalEnergy -= a;
            System.out.println(p + "에 " + a + "의 에너지가 할당되었습니다. 남은 전체에너지 : " + totalEnergy);

            if (totalEnergyLessThan1000.test(totalEnergy)) {
                System.out.println("경고: 남은 에너지가 1000 이하입니다.");
            }
        };

        allocator.allocateEnergy(place, amount);
    }

    Predicate<Integer> totalEnergyLessThan1000 = (totalEnergy) -> totalEnergy <= 1000;

}

