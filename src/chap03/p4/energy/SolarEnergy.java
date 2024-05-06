package chap03.p4.energy;

public class SolarEnergy extends EnergySource {

    public SolarEnergy(String sourceName) {
        super(sourceName);
    }

    @Override
    public void produceEnergy(int sunlightHours) {
        int producedEnergy = sunlightHours * 10;
        this.energyAmount += producedEnergy;
        System.out.println(this.sourceName + " 에너지를 " + producedEnergy +"만큼 생산했습니다.");
    }
}
