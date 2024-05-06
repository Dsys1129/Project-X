package chap03.p1;

import java.util.ArrayList;
import java.util.List;

public class LifeNest {
    private List<Organism> organismList = new ArrayList<>();

    public void addOrganism(Organism organism) {
        this.organismList.add(organism);
        System.out.println("[LifeNest] " + organism.getName() + "이 추가되었습니다.");
    }

    public void removeOrganism(Organism organism) {
        this.organismList.remove(organism);
        System.out.println("[LifeNest] " + organism.getName() + "이 삭제되었습니다");
    }

    public void printAllOrganism() {
        System.out.println();
        System.out.println("전체 동식물 목록 출력:");
        int index = 1;
        for (Organism organism : organismList) {
            System.out.println(index +". " + organism.displayInfo());
            index++;
        }
        System.out.println();
    }

    public void searchOrganismByName(String name) {
        for (Organism organism : organismList) {
            if (organism.getName().equals(name)) {
                System.out.println(organism.getName() +"은/는 " +
                        organism.getSpecies() + "이며 " +
                        organism.getHabitat() + "에 서식합니다.");
                return;
            }
        }
        System.out.println("검색 결과가 없습니다.");
    }
}
