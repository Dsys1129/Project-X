package chap03.p4.energy;

public class WindEnergy extends EnergySource {

    public WindEnergy(String sourceName) {
        super(sourceName);
    }

    @Override
    public void produceEnergy(int windSpeed) {
        int producedEnergy = windSpeed * 5;
        this.energyAmount += producedEnergy;
        System.out.println(this.sourceName + " 에너지를 " + producedEnergy +"만큼 생산했습니다.");
    }
}
