package chap04.p4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BiologicalSystem<T> {
    private List<BiologicalEntity<T>> biologicalEntityList;

    public BiologicalSystem() {
        this.biologicalEntityList = new ArrayList<>();
        System.out.println("생물정보 시스템이 생성되었습니다.");
    }

    public void add(BiologicalEntity<T> biologicalEntity) {
        biologicalEntityList.add(biologicalEntity);
        System.out.println("새로운 생물이 등록되었습니다 : " + biologicalEntity.getName());
    }

    public void delete() {
        if (biologicalEntityList.isEmpty()) {
            System.out.println("저장된 생물이 없습니다.");
            return;
        }

        BiologicalEntity<T> lastBiologicalEntity = biologicalEntityList.get(biologicalEntityList.size() - 1);
        biologicalEntityList.remove(lastBiologicalEntity);
        System.out.println("생물이 삭제 되었습니다 : " + lastBiologicalEntity);
    }

    public void show() {
        if (biologicalEntityList.isEmpty()) {
            System.out.println("저장된 생물이 없습니다.");
            return;
        }
        System.out.println("최신 등록 생물 : " + biologicalEntityList.get(biologicalEntityList.size() - 1));
    }

    public void clear() {
        biologicalEntityList.clear();
        System.out.println("모든 정보를 삭제했습니다.");
    }

    public void isEmpty() {
        if (biologicalEntityList.isEmpty()) {
            System.out.println("생물 정보 리스트는 비어있습니다.");
            return;
        }
        System.out.println("생물 정보 리스트가 비어있지 않습니다.");
    }

    public void sortByNameOrderByASC() {
        Collections.sort(biologicalEntityList, new Comparator<BiologicalEntity<T>>() {
            @Override
            public int compare(BiologicalEntity<T> o1, BiologicalEntity<T> o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void printAllBiologicalEntity() {
        System.out.println("\n(이름 오름 차순 정렬 후 차례대로 출력)");
        for (BiologicalEntity<T> biologicalEntity : biologicalEntityList) {
            System.out.println(biologicalEntity.toString());
        }
    }
}
