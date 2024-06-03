package chap06.p9;

import java.util.HashMap;

public class CentralWaterCenter {

    private static CentralWaterCenter centralWaterCenter;
    private HashMap<String, Integer> regionWaterAmountMap = new HashMap<>();
    private int waterAmount = 10000;

    public static CentralWaterCenter getInstance() {
        if (centralWaterCenter == null) {
            synchronized (CentralWaterCenter.class) {
                if (centralWaterCenter == null) {
                    centralWaterCenter = new CentralWaterCenter();
                }
            }
        }
        return centralWaterCenter;
    }

    public synchronized void allocateWater(String regionName, int amount) {
        if (this.waterAmount < amount) {
            System.out.println("중앙 센터에 요청한 만큼의 물이 남아있지 않습니다. 물이 부족합니다.");
            return;
        }

        // 해당 지역의 현재 물 양 조회
        int currentWaterAmount = regionWaterAmountMap.getOrDefault(regionName, 0);

        this.waterAmount -= amount;
        regionWaterAmountMap.put(regionName, currentWaterAmount + amount);
        System.out.println(regionName + "에 " + amount + "만큼의 물을 할당하였습니다.");
    }

    public int printRegionWaterAmount(String regionName) {
        return regionWaterAmountMap.getOrDefault(regionName, 0);
    }

    public int getWaterAmount() {
        return waterAmount;
    }
}
