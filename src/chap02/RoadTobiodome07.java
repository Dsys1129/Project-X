package chap02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 입력 예시
// "[사자, 얼룩말, 악어, 표범, 사자, 늑대, 악어, 늑대, 사자, 표범, 늑대, 악어, 얼룩말, 사자]"
public class RoadTobiodome07 {

    public static void main(String[] args) {
        if (args.length < 1 || args[0].isBlank()) {
            System.out.println("입력값이 올바르지 않습니다. 다시 확인해주세요");
        }

        System.out.println("입력 : " + args[0]);
        String[] input = args[0].replaceAll("[\\[\\],]", "").split(" ");

        if (!isNumbers(input)) {
            System.out.println("입력값이 올바르지 않습니다. 다시 확인해주세요");
            return;
        }

        Map<String, Integer> animalMap = createAnimalMap(input);

        // 입력받은 동물 관찰 데이터에 등장하는 고유한 동물 이름을 저장하는 별도의 배열을 생성한다.
        Animal[] animals = createAnimalsArr(animalMap);

        Animal[] sortedAnimals = selectionSortOrderByDESC(animals);
        String[] result = new String[sortedAnimals.length];

        for (int i = 0; i < sortedAnimals.length; i++) {
            result[i] = sortedAnimals[i].getName();
        }

        mergeSortOrderByDESC(animals, 0, animals.length - 1);
        String[] bonusResult = new String[sortedAnimals.length];
        for (int i = 0; i < sortedAnimals.length; i++) {
            bonusResult[i] = animals[i].getName();
        }

        System.out.println("기본 문제 출력 : " + Arrays.toString(result));
        System.out.println("보너스 문제 (Merge Sort 출력) : " + Arrays.toString(bonusResult));

    }

    private static Animal[] createAnimalsArr(Map<String, Integer> animalMap) {
        Animal[] animals = new Animal[animalMap.size()];

        int index = 0;
        for (String name : animalMap.keySet()) {
            animals[index++] = new Animal(name, animalMap.get(name));
        }
        return animals;
    }

    private static Map<String, Integer> createAnimalMap(String[] input) {
        HashMap<String, Integer> animalMap = new HashMap<>();

        for (String str : input) {
            animalMap.put(str, animalMap.getOrDefault(str, 0) + 1);
        }
        return animalMap;
    }

    private static boolean isNumbers(String[] strings) {
        for (String s : strings) {
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Animal[] selectionSortOrderByDESC(Animal[] animals) {
        Animal[] sortedAnimals = Arrays.copyOf(animals, animals.length);

        for (int i = 0; i < sortedAnimals.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < sortedAnimals.length; j++) {
                if (sortedAnimals[maxIndex].getCount() < sortedAnimals[j].getCount()) {
                    maxIndex = j;

                } else if (sortedAnimals[maxIndex].getCount() == sortedAnimals[j].getCount()) {
                    String animalName1 = sortedAnimals[maxIndex].getName();
                    String animalName2 = sortedAnimals[j].getName();

                    // 현재 Max번째 동물의 이름이 j번째 동물의 이름보다 사전순으로 뒤에있다면 swap
                    if (animalName1.compareTo(animalName2) > 0) {
                        maxIndex = j;
                    }
                }
            }
            // Swap
            Animal temp = sortedAnimals[i];
            sortedAnimals[i] = sortedAnimals[maxIndex];
            sortedAnimals[maxIndex] = temp;
        }
        return sortedAnimals;
    }

    private static void mergeSortOrderByDESC(Animal[] animals, int start, int end) {
        // 배열의 크기가 1까지만 분할
        if (end - start < 1) {
            return;
        }

        int middle = start + (end - start) / 2;

        mergeSortOrderByDESC(animals, start, middle);
        mergeSortOrderByDESC(animals, middle + 1, end);

        merge(animals, start, middle, end);
    }

    private static void merge(Animal[] animals, int start, int middle, int end) {
        Animal[] temp = new Animal[end - start + 1];
        int idx = 0;

        int left = start;
        int right = middle + 1;

        while (left <= middle && right <= end) {
            if (animals[left].getCount() > animals[right].getCount()) {
                temp[idx++] = animals[left++];
            } else if (animals[left].getCount() < animals[right].getCount()) {
                temp[idx++] = animals[right++];

                // Count 값이 같다면 사전순
            } else {
                if (animals[left].getName().compareTo(animals[right].getName()) <= 0) {
                    temp[idx++] = animals[left++];
                } else {
                    temp[idx++] = animals[right++];
                }
            }
        }

        while (left <= middle) {
            temp[idx] = animals[left];
            idx++;
            left++;
        }

        while (right <= end) { //오른쪽 리스트에 값이 남아 있는 경우
            temp[idx] = animals[right];
            idx++;
            right++;
        }

        for (int i = start; i <= end; i++) {
            animals[i] = temp[i - start];
        }
    }

    static class Animal {
        private String name;
        private int count;

        public Animal(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }
    }
}
