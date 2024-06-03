package chap06.p7;

public class City {

    private String name;
    private int energy;

    public City(String name) {
        this.name = name;
    }

    public void displayEnergyAmount() {
        System.out.println(" - " + this.name + " : " + this.energy);
    }

    public void requestEnergy(int energy) {
        this.energy += energy;
    }

    public void notifyEnergyReplenishment(int energy) {
        System.out.println(" - " + this.name + " : 중앙 센터에 에너지가 " + energy + " 보충되었습니다.");
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }
}
