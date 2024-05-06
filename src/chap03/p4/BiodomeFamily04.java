package chap03.p4;

import chap03.p4.energy.EnergyManager;
import chap03.p4.energy.GeothermalEnergy;
import chap03.p4.energy.SolarEnergy;
import chap03.p4.energy.WindEnergy;

public class BiodomeFamily04 {

    public static void main(String[] args) {
        SolarEnergy solarEnergy = new SolarEnergy("태양광");
        WindEnergy windEnergy = new WindEnergy("풍력");
        GeothermalEnergy geothermalEnergy = new GeothermalEnergy("지열");

        solarEnergy.produceEnergy(5);
        windEnergy.produceEnergy(12);
        geothermalEnergy.produceEnergy(4);

        System.out.println();

        solarEnergy.useEnergy(30);
        windEnergy.useEnergy(30);
        geothermalEnergy.useEnergy(30);

        System.out.println();

        EnergyManager energyManager = new EnergyManager();
        int totalEnergy = energyManager.calculateTotalEnergy(solarEnergy, windEnergy, geothermalEnergy);
        System.out.println("남은 에너지 : " + totalEnergy);

        System.out.println();
        System.out.println("========================== Bonus ======================");

        solarEnergy = new SolarEnergy("태양광");
        windEnergy = new WindEnergy("풍력");
        geothermalEnergy = new GeothermalEnergy("지열");

        solarEnergy.produceEnergy(1);
        windEnergy.produceEnergy(4);
        geothermalEnergy.produceEnergy(2);

        System.out.println();

        solarEnergy.useEnergy(30);
        windEnergy.useEnergy(30);
        geothermalEnergy.useEnergy(30);

        System.out.println();

        int bonusResult = energyManager.calculateTotalEnergy(solarEnergy, windEnergy, geothermalEnergy);
        System.out.println("남은 에너지 : " + bonusResult);
    }
}
