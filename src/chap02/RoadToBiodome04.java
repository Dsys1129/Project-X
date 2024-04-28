package chap02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 기본 문제 입력 형식 "[5, 3, 8, 9, 4]"
// 보너스 문제 입력 형식 "[5, 3, 8, 9, 4]" "[7, 2, 10, 6]"
public class RoadToBiodome04 {

    public static void main(String[] args) {

        // 보너스 문제
        if (args.length > 1) {
            bonusProblem(args);
            return;
        }

        // 기본 문제
        System.out.println("입력 : " + args[0]);
        String[] input1 = args[0].replaceAll("[\\[\\],]", "").split(" ");

        int[] energies = new int[input1.length];
        for (int i = 0; i < input1.length; i++) {
            energies[i] = Integer.parseInt(input1[i]);
        }

        int[] sortedEnergies = Sorter.selectionSortOrderByASC(energies);
        System.out.println("평균값 : " + ArrayUtils.getAverage(sortedEnergies) +
                ", 중앙값 : " + ArrayUtils.getMidValue(sortedEnergies));
    }

    private static void bonusProblem(String[] args) {
        List<int[]> energyList = new ArrayList<>();
        StringBuilder inputBuilder = new StringBuilder();
        StringBuilder outputBuilder = new StringBuilder();
        for (String arg : args) {
            inputBuilder.append(arg).append(" ");
        }

        System.out.println("입력 : " + inputBuilder.toString().trim());

        outputBuilder.append("보너스 문제 >>> ");

        for (int i = 0; i < args.length; i++) {
            energyList.add(ArrayUtils.createArrAtInput(args[i]));
        }

        for (int i = 0; i < energyList.size(); i++) {
            int[] energies = energyList.get(i);
            int[] sortedEnergies = Sorter.selectionSortOrderByASC(energies);
            double midValue = ArrayUtils.getMidValue(sortedEnergies);

            if (i == energyList.size() - 1) {
                outputBuilder.append(midValue);
            } else {
                outputBuilder.append(midValue).append(", ");
            }
        }
        System.out.println(outputBuilder);
    }

    public static class ArrayUtils {
        private static int[] createArrAtInput(String str) {
            String[] input = str.replaceAll("[\\[\\],]", "").split(" ");
            int[] resultArr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                resultArr[i] = Integer.parseInt(input[i]);
            }
            return resultArr;
        }

        private static double getMidValue(int[] energies) {
            int length = energies.length;
            if (length % 2 == 0) {
                return getAverage(energies[(length / 2) - 1], (energies[length / 2]));
            }

            return energies[length / 2];
        }

        private static double getAverage(int[] energies) {
            return Arrays.stream(energies).average().getAsDouble();
        }

        private static double getAverage(int num1, int num2) {
            return ((double) num1 + num2) / 2;
        }
    }

    static class Sorter {
        private static int[] selectionSortOrderByASC(int[] energies) {
            int[] sortedEnergies = Arrays.copyOf(energies, energies.length);

            for (int i = 0; i < sortedEnergies.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < sortedEnergies.length; j++) {
                    if (sortedEnergies[minIndex] > sortedEnergies[j]) {
                        minIndex = j;
                    }
                }

                // Swap
                int temp = sortedEnergies[i];
                sortedEnergies[i] = sortedEnergies[minIndex];
                sortedEnergies[minIndex] = temp;
            }
            return sortedEnergies;
        }
    }
}
