package chap03.p5;

public class SolarStone extends AncientArtifact implements EnergyGenerator, Chargeable {

    private int chargeLevel;

    public SolarStone(String name) {
        super(name);
        chargeLevel = 0;
    }

    @Override
    public void describe() {
        System.out.println(this.name + " : " + "빛을 받아 에너지 생성(예. 빛을 받은 시간에 영향을 받음)");
    }

    @Override
    public void generateEnergy() {
        System.out.println(this.name + " : " + "빛을 받아 에너지 생성중");
    }

    @Override
    public void setChargeLevel(int amount) {
        this.chargeLevel += amount;
    }

    @Override
    public int getChargeLevel() {
        System.out.println("태양의 돌에 총 " + this.chargeLevel + "만큼의 에너지가 충전되었습니다.");
        return this.chargeLevel;
    }


    @Override
    public void charge(int amount) {
        System.out.println("태양의 돌에 " + amount + "만큼 에너지를 충전합니다.");
        setChargeLevel(amount);
    }
}
