package chap02;

import java.util.Arrays;

// 입력 형식 "[11, 69, 41, 3, 10, 65, 7, 8]" "[30, 5, 79, 57, 1, 13, 28, 88, 18, 24]"
public class RoadToBiodome05 {

    public static void main(String[] args) {

        if (args.length < 2 || args.length > 2) {
            System.out.println("값을 2개 입력해 주세요");
            return;
        }

        System.out.println("입력 : " + args[0] + " " + args[1]);
        String[] input1 = args[0].replaceAll("[\\[\\],]", "").split(" ");
        String[] input2 = args[1].replaceAll("[\\[\\],]", "").split(" ");
        if (!isNumbers(input1) || !isNumbers(input2)) {
            System.out.println("숫자가 아닌 값이 포함되어 있습니다.");
            return;
        }

        // 두 개의 배열을 하나로 합친다.
        int[] mergedArr = new int[input1.length + input2.length];

        for (int i = 0; i < input1.length; i++) {
            int number = Integer.parseInt(input1[i]);
            // 물 높이는 최소 0, 최대 10^3 값을 갖는다
            if (number < 0 || number > 1000) {
                System.out.println("물 높이 범위에 해당하지 않는 수가 있습니다.");
                return;
            }
            mergedArr[i] = number;
        }

        for (int i = 0; i < input2.length; i++) {
            int number = Integer.parseInt(input2[i]);
            if (number < 0 || number > 1000) {
                System.out.println("물 높이 범위에 해당하지 않는 수가 있습니다.");
                return;
            }
            mergedArr[input1.length + i] = number;
        }

        int[] quickSortedArr = Sorter.quickSortOrderByASC(mergedArr, 0, mergedArr.length - 1);
        System.out.println("기존 문제(Quick Sort) >> " + Arrays.toString(quickSortedArr));
        int[] bubbleSortedArr = Sorter.bubbleSortOrderByASC(mergedArr);
        System.out.println("보너스 문제(Bubble Sort) >> " + Arrays.toString(bubbleSortedArr));
    }

    private static boolean isNumbers(String[] strings) {
        for (String s : strings) {
            for (char c : s.toCharArray()) {
                if (c < '0' || c > '9') {
                    return false;
                }
            }
        }
        return true;
    }

    static class Sorter {

        public static int[] quickSortOrderByASC(int[] numbers, int low, int high) {
            if (low >= high) {
                return numbers;
            }

            int divide = divide(numbers, low, high);
            quickSortOrderByASC(numbers, low, divide - 1);
            quickSortOrderByASC(numbers, divide, high);
            return numbers;
        }

        private static int divide(int[] numbers, int low, int high) {
            int mid = (low + high) / 2;
            int pivot = numbers[mid];

            while (low <= high) {

                while (numbers[low] < pivot) {
                    low++;
                }

                while (numbers[high] > pivot) {
                    high--;
                }

                if (low <= high) {
                    // swap
                    int temp = numbers[low];
                    numbers[low] = numbers[high];
                    numbers[high] = temp;

                    low++;
                    high--;
                }
            }
            return low;
        }

        public static int[] bubbleSortOrderByASC(int[] numbers) {
            int[] sortedArr = Arrays.copyOf(numbers, numbers.length);
            for (int i = 0; i < sortedArr.length - 1; i++) {
                for (int j = 0; j < sortedArr.length - i - 1; j++) {
                    if (sortedArr[j] > sortedArr[j + 1]) {
                        int temp = sortedArr[j];
                        sortedArr[j] = sortedArr[j + 1];
                        sortedArr[j + 1] = temp;
                    }
                }
            }
            return sortedArr;
        }
    }
}
