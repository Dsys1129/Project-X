package chap03.p5;

import java.util.ArrayList;
import java.util.List;

public class Sorcerer {

    private String name;

    private List<AncientArtifact> ancientArtifactList = new ArrayList<>();

    public Sorcerer(String name) {
        this.name = name;
        System.out.println("마법사 " + "\'" + this.name + "\'" + "이 생성되었습니다.");
    }

    public void addAncientArtifact(AncientArtifact ancientArtifact) {
        ancientArtifactList.add(ancientArtifact);
        System.out.println("마법사 " + "\'" + this.name + "\'" + "이 " + ancientArtifact.getName() + " 유물을 소유하게 되었습니다.");
    }

    public void checkArtifactDescribe(AncientArtifact ancientArtifact) {
        System.out.println("마법사 " + "\'" + this.name + "\'" + "이 " + ancientArtifact.getName() + "의 능력을 확인합니다.");
        ancientArtifact.describe();
    }

    public void useArtifact(AncientArtifact ancientArtifact) {
        System.out.println("마법사 " + "\'" + this.name + "\'" + "이 " + ancientArtifact.getName() + "의 능력을 사용합니다.");
        if (ancientArtifact instanceof  EnergyGenerator && ancientArtifact instanceof  WeatherController) {
            ((EnergyGenerator) ancientArtifact).generateEnergy();
            ((WeatherController) ancientArtifact).controlWeather();
            return;
        }
        if (ancientArtifact instanceof EnergyGenerator) {
           ((EnergyGenerator) ancientArtifact).generateEnergy();
           return;
        }
        if (ancientArtifact instanceof WeatherController) {
            ((WeatherController) ancientArtifact).controlWeather();
            return;
        }
    }

    public String getName() {
        return this.name;
    }
}
