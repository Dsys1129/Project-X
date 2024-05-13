package chap04.p6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//TODO 기본 보너스 완료

// 입력 타입 : "[호랑이, 사자, 악어, 표범, 하이에나, 치타, 호랑이, 사자, 표범, 하이에나, 악어, 호랑이, 하이에나, 치타, 호랑이, 코뿔소, 사자, 악어, 표범, 하이에나, 치타, 호랑이, 사자, 악어, 표범, 하이에나, 치타, 호랑이, 사자, 악어, 표범, 하이에나, 치타, 호랑이, 사자, 악어, 하이에나, 치타, 호랑이, 사자, 표범, 호랑이, 사자, 악어, 하이에나, 치타, 표범, 하이에나, 치타, 코뿔소, 호랑이]"
public class RuleOfBiodome06 {

    public static void main(String[] args) {
        String[] animals = args[0].replaceAll("[\\[\\],]", "").split(" ");
        System.out.println("입력 : " + Arrays.toString(animals));
        AnimalFrequencyAnalyzer animalFrequencyAnalyzer = new AnimalFrequencyAnalyzer();
        animalFrequencyAnalyzer.updateAnimalCountMap(animals);

        System.out.println("가장 많이 발견된 동물 : " + animalFrequencyAnalyzer.getMostFrequentAnimalName());
        System.out.println("관찰된 모든 동물 : " + animalFrequencyAnalyzer.getUniqueAnimalNames().toString());

        System.out.println("\n======================= Bonus =======================");
        Map<Integer, List<String>> animalsGroupsByFrequencyMap = animalFrequencyAnalyzer.getAnimalsGroupsByFrequency();
        animalFrequencyAnalyzer.printAnimalGroups(animalsGroupsByFrequencyMap);
    }
}
