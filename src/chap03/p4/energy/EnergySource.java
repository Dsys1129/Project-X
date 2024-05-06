package chap03.p4.energy;

public abstract class EnergySource {

    // 모든 에너지 원천은 sourceName을 필드로 가지며, 한번 정해진 이름은 변경할 수 없다.
    protected final String sourceName;
    protected int energyAmount;

    public EnergySource(String sourceName) {
        this.sourceName = sourceName;
        this.energyAmount = 0;
    }

    public void useEnergy(int amount) {
        if (this.energyAmount < amount) {
            System.out.println("에너지가 부족해 " +
                    this.sourceName + "에너지 " + amount +"를 사용할 수 없습니다.");
            return;
        }
        this.energyAmount -= amount;
        System.out.println(this.sourceName + " : " + "에너지를 " + amount + "사용했습니다.");
    }
    public abstract void produceEnergy(int amount);

    public int getEnergyAmount() {
        return energyAmount;
    }
}
