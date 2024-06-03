package chap06.p9;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class BonusCentralWaterCenter {

    private static BonusCentralWaterCenter bonusCentralWaterCenter;
    private HashMap<String, Integer> regionWaterAmountMap = new HashMap<>();
    private int waterAmount = 10000;
    private ReentrantLock reentrantLock = new ReentrantLock();

    public static BonusCentralWaterCenter getInstance() {
        if (bonusCentralWaterCenter == null) {
            synchronized (BonusCentralWaterCenter.class) {
                if (bonusCentralWaterCenter == null) {
                    bonusCentralWaterCenter = new BonusCentralWaterCenter();
                }
            }
        }
        return bonusCentralWaterCenter;
    }

    public void allocateWater(String regionName, int amount) {
        reentrantLock.lock();
        try {
            if (this.waterAmount < amount) {
                System.out.println("중앙 센터에 요청한 만큼의 물이 남아있지 않습니다. 물이 부족합니다.");
                return;
            }

            // 해당 지역의 현재 물 양 조회
            int currentWaterAmount = regionWaterAmountMap.getOrDefault(regionName, 0);

            // 지역 및 전체 물 양 감소
            this.waterAmount -= amount;
            regionWaterAmountMap.put(regionName, currentWaterAmount + amount);
            System.out.println(regionName + "에 " + amount + "만큼의 물을 할당하였습니다.");
        } finally {
            reentrantLock.unlock();
        }
    }

    public int getWaterAmount() {
        return waterAmount;
    }
}
