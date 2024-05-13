package chap04.p6;

import java.util.*;

public class AnimalFrequencyAnalyzer {

    private Map<String, Integer> animalCountMap;

    public AnimalFrequencyAnalyzer() {
        this.animalCountMap = new HashMap<>();
    }

    public void updateAnimalCountMap(String[] animals) {
        for (String animal : animals) {
            animalCountMap.put(animal, animalCountMap.getOrDefault(animal, 0) + 1);
        }
    }

    public String getMostFrequentAnimalName() {
        int maxValue = Integer.MIN_VALUE;
        String maxAnimalName = null;
        for (Map.Entry<String, Integer> entry : animalCountMap.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxAnimalName = entry.getKey();
            }
        }
        return maxAnimalName;
    }

    public Set<String> getUniqueAnimalNames() {
        return animalCountMap.keySet();
    }

    public Map<Integer, List<String>> getAnimalsGroupsByFrequency() {
        Map<Integer, List<String>> animalGroupMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : animalCountMap.entrySet()) {
            int frequency = entry.getValue();
            String animalName = entry.getKey();

            List<String> groupedAnimals = animalGroupMap.getOrDefault(frequency, new ArrayList<>());

            groupedAnimals.add(animalName);
            animalGroupMap.put(frequency, groupedAnimals);
        }
        return animalGroupMap;
    }

    public void printAnimalGroups(Map<Integer, List<String>> animalGroupMap) {
        for (Map.Entry<Integer, List<String>> animalGroup : animalGroupMap.entrySet()) {
            int frequency = animalGroup.getKey();
            List<String> animalNames = animalGroup.getValue();
            System.out.println(frequency + "회: " + animalNames);
        }
    }
}
