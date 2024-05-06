package chap03.p4.energy;


public class EnergyManager {

    public int calculateTotalEnergy(EnergySource... energySources) {
        int totalEnergy = 0;
        for (EnergySource energySource : energySources) {
            totalEnergy += energySource.getEnergyAmount();
        }
        return totalEnergy;
    }
}
