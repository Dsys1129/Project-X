package chap03.p5;

public class WaterMirror extends AncientArtifact implements EnergyGenerator, WeatherController, Chargeable {
    private int chargeLevel;

    public WaterMirror(String name) {
        super(name);
    }

    @Override
    public void describe() {
        System.out.println(this.name + " : " + "수증기를 모아 에너지를 생성하고, 날씨를 조절함(예. 습도에 영향을 받으며, 비와 눈을 내림)");
    }

    @Override
    public void controlWeather() {
        System.out.println(this.name + " : " + "수증기를 이용해 날씨를 조절중");
    }

    @Override
    public void generateEnergy() {
        System.out.println(this.name + " : " + "수증기를 모아 에너지를 생성중");
    }

    @Override
    public void charge(int amount) {
        System.out.println("물의 거울에 " + amount + "만큼 에너지를 충전합니다.");
        setChargeLevel(amount);
    }

    @Override
    public void setChargeLevel(int amount) {
        this.chargeLevel += amount;
    }

    @Override
    public int getChargeLevel() {
        System.out.println("물의 거울에 총 " + this.chargeLevel + "만큼의 에너지가 충전되었습니다.");
        return this.chargeLevel;
    }
}
