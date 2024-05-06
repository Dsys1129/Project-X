package chap03.p4.energy;

public class GeothermalEnergy extends EnergySource {

    public GeothermalEnergy(String sourceName) {
        super(sourceName);
    }

    @Override
    public void produceEnergy(int temperature) {
        int producedEnergy = (temperature * 5) + 20;
        this.energyAmount += producedEnergy;
        System.out.println(this.sourceName + " 에너지를 " + producedEnergy +"만큼 생산했습니다.");
    }
}
