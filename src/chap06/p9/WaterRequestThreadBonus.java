package chap06.p9;

public class WaterRequestThreadBonus extends Thread {

    private String regionName;
    private int requestWaterAmount;

    public WaterRequestThreadBonus(String regionName, int requestWaterAmount) {
        this.regionName = regionName;
        this.requestWaterAmount = requestWaterAmount;
    }

    @Override
    public void run() {
        if (requestWaterAmount < 0) {
            System.out.println(this.regionName + "에 마이너스값이 입력되었습니다. 다시 한번 확인해주세요.");
            return;
        }
        BonusCentralWaterCenter.getInstance().allocateWater(this.regionName, this.requestWaterAmount);
    }
}
