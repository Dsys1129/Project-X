package chap02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RoadToBiodome06 {

    public static void main(String[] args) {
        if (args.length < 2 || args.length > 2) {
            System.out.println("입력값이 올바르지 않습니다");
            return;
        }

        String[] input1 = args[0].replaceAll("[\\[\\],]", "").split(" ");
        String[] input2 = args[1].replaceAll("[\\[\\],]", "").split(" ");

        if (!isNumbers(input1) || !isNumbers(input2)) {
            System.out.println("숫자가 아닌 값이 포함되어 있습니다.");
            return;
        }

        int n = input1.length;
        int m = input2.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for (int i = 0; i < input1.length; i++) {
            int number = Integer.parseInt(input1[i]);
            if (number < 0 || number > 1000) {
                System.out.println("물 높이 범위에 해당하지 않는 수가 있습니다.");
                return;
            }
            arr1[i] = number;
        }

        for (int i = 0; i < input2.length; i++) {
            int number = Integer.parseInt(input2[i]);
            if (number < 0 || number > 1000) {
                System.out.println("물 높이 범위에 해당하지 않는 수가 있습니다.");
                return;
            }
            arr2[i] = number;
        }
        System.out.println("입력 : " + Arrays.toString(arr1) + " , " + Arrays.toString(arr2));

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        double mean = getMeans(arr1, arr2);
        double median = getMedianUsingBinarySearch(arr1, arr2);

        //bonus
        int[] bonusArr1 = IntStream.of(arr1).filter(i -> i >= 30).toArray();
        int[] bonusArr2 = IntStream.of(arr2).filter(i -> i >= 30).toArray();

        double bonusMean = getMeans(bonusArr1, bonusArr2);
        double bonusMedian = getMedianUsingBinarySearch(bonusArr1, bonusArr2);

        System.out.println("Mean : " + String.format("%.1f", mean));
        System.out.println("Median : " + String.format("%.1f", median));


        System.out.println("보너스 문제 >>> " + "Mean : " + String.format("%.1f", bonusMean) +
                " Median : " + String.format("%.1f", bonusMedian));
    }

    private static double getMeans(int[] arr1, int[] arr2) {
        int sumOfArr1 = Arrays.stream(arr1).sum();
        int sumOfArr2 = Arrays.stream(arr2).sum();

        return  (double)(sumOfArr1 + sumOfArr2) / (arr1.length + arr2.length);
    }

    // log - > binary Search
    // 중앙값일 조건
    // 1. shortArr 왼쪽 부분의 최대값(shortArrLeft)가 longArr의 오른쪽 부분의 최소값(longArrRight)의 값보다 작거나 같음
    // 2. longArr 왼쪽 부분의 최대값(longArrLeft)가 shortArr의 오른쪽 부분의 최소값 보다 작거나 같아야함
    // ==> 왼쪽 그룹의 모든 수는 오른쪽 그룹의 모든 수보다 작아야 함
    // 3. 전체 개수가 짝수일때, 왼쪽 그룹의 원소의 개수와 오른쪽 그룹의 원소의 개수가 같아야함
    // 4. 전체 개수가 홀수일때, 왼쪽 그룹의 원소의 개수와 오른쪽 그룹의 원소의 개수가 하나 차이나야 함
    private static double getMedianUsingBinarySearch(int[] arr1, int[] arr2) {
        int[] shortArr = Arrays.copyOf(arr1, arr1.length);
        int[] longArr = Arrays.copyOf(arr2, arr2.length);

        if (arr1.length > arr2.length) {
            shortArr = Arrays.copyOf(arr2, arr2.length);
            longArr = Arrays.copyOf(arr1, arr1.length);
        }
        double result = 0;
        int shortArrLength = shortArr.length;
        int longArrLength = longArr.length;;
        int totalLength = shortArrLength + longArrLength;

        // Binary Search를 위한 포인터들
        int left = 0;
        int right = shortArrLength;
        int half = (shortArrLength + longArrLength + 1) / 2;


        while (left <= right) {
            int shortArrPointer = left + ((right - left) / 2); // shortArr의 포인터
            int longArrPointer = half - shortArrPointer; // longArr의 포인터

            int shortArrLeft = (shortArrPointer > 0) ? shortArr[shortArrPointer - 1] : Integer.MIN_VALUE;
            int shortArrRight = (shortArrPointer < shortArrLength) ? shortArr[shortArrPointer] : Integer.MAX_VALUE; // shortArr

            int longArrLeft = (longArrPointer > 0) ? longArr[longArrPointer - 1] : Integer.MIN_VALUE;
            int longArrRight = (longArrPointer < longArrLength) ? longArr[longArrPointer] : Integer.MAX_VALUE;

            if (shortArrLeft <= longArrRight && longArrLeft <= shortArrRight) {

                if (totalLength % 2 == 0) {
                    result = (CustomMath.max(shortArrLeft, longArrLeft) + CustomMath.min(shortArrRight, longArrRight)) / 2.0;
                } else {
                    result = CustomMath.max(shortArrLeft, longArrLeft);
                }
                break;
            }
            else if (shortArrLeft > longArrRight) {
                right = shortArrPointer - 1;
            } else {
                left = shortArrPointer + 1;
            }
        }

        return result;
    }

    private static boolean isNumbers(String[] strings) {
        for (String s : strings) {
            for (char c : s.toCharArray()) {
                if (c < '0' && c > '9') {
                    return false;
                }
            }
        }
        return true;
    }

    static class CustomMath {

        public static int max(int number1, int number2) {
            if (number1 >= number2) {
                return number1;
            }
            return number2;
        }

        public static int min(int number1, int number2) {
            if (number1 <= number2) {
                return number1;
            }
            return number2;
        }
    }
}


