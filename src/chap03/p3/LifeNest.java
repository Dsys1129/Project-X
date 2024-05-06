package chap03.p3;

import java.util.ArrayList;
import java.util.List;

public class LifeNest {

    private List<Organism> organismList = new ArrayList<>();

    public void addOrganism(Organism organism) {
        this.organismList.add(organism);
        System.out.println("[LifeNest] " + organism.getName() + "이/가 추가되었습니다.");
    }

    public void removeOrganism(Organism organism) {
        this.organismList.remove(organism);
        System.out.println("[LifeNest] " + organism.getName() + "이/가 삭제되었습니다");
    }

    public void displayAll() {
        System.out.println();
        System.out.println("전체 동식물 목록 출력:");
        int index = 1;
        for (Organism organism : organismList) {
            System.out.println(index +". " + organism.displayInfo());
            index++;
        }
        System.out.println();
    }
}
