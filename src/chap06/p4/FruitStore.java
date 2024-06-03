package chap06.p4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FruitStore {

    private static final String FOLDER_PATH = "src/chap06/p4/file/";
    private static final String FILE_NAME = "fruit_data_total.csv";

    private HashMap<String, Integer> stockMap = new HashMap<>();
    private HashMap<String, String> transactionsMap = new HashMap<>();

    public FruitStore() {
        transactionsMap.put("블루베리", "3,2131-04-01:10,2131-04-02:30,2131-04-03:12");
        transactionsMap.put("딸기", "2,2131-04-01:35,2131-04-02:12,2131-04-03:15");
        transactionsMap.put("사과", "1,2131-04-01:25,2131-04-02:30,2131-04-03:20");
        transactionsMap.put("바나나", "5,2131-04-01:28,2131-04-02:12,2131-04-03:6");
        transactionsMap.put("오렌지", "1,2131-04-01:20,2131-04-02:18,2131-04-03:15");
        transactionsMap.put("키위", "2,2131-04-01:12,2131-04-02:8,2131-04-03:7");
        transactionsMap.put("복숭아", "3,2131-04-01:19,2131-04-02:21,2131-04-03:12");
        transactionsMap.put("포도", "1,2131-04-01:10,2131-04-02:13,2131-04-03:9");
        transactionsMap.put("파인애플", "0,2131-04-01:7,2131-04-02:16,2131-04-03:12");
        transactionsMap.put("체리", "2,2131-04-01:21,2131-04-02:32,2131-04-03:10");
        try {
            getFruitData();
        } catch (IOException e) {
            throw new RuntimeException("과일 정보 데이터를 불러오는 중 에러가 발생하였습니다.");
        }
    }

    private void getFruitData() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(FOLDER_PATH + FILE_NAME), StandardCharsets.UTF_8)) {
            StringBuilder stringBuilder = new StringBuilder();
            lines.forEach(line -> stringBuilder.append(line).append("\n"));

            String parsingData = stringBuilder.toString();
            String[] parsingDataLines = parsingData.split("\n");
            for (int i = 1; i < parsingDataLines.length; i++) {
                String[] split = parsingDataLines[i].split(",");
                stockMap.put(split[0], Integer.parseInt(split[1]));
            }
        }
    }

    public void showAverages() {
        for (String fruit : transactionsMap.keySet()) {

            String transactions = getTransactionsWithoutPrefix(transactionsMap.get(fruit));
            List<String> split = Arrays.stream(transactions.split(",")).toList();
            double average = split.stream()
                    .mapToDouble(s -> Double.parseDouble(s.split(":")[1]))
                    .average()
                    .orElse(0.0);

            System.out.println(fruit + "의 평균 판매 개수 : " + String.format("%.1f", average));
        }
    }

    public void showAllStock() {
        System.out.println("모든 과일 재고량: ");
        stockMap.entrySet().stream().forEach((fruit) ->
                System.out.println(fruit.getKey() + "-" + fruit.getValue() + "개"));
    }

    public void showMostSoldFruit() {
        int max = -1;
        String maxFruit = null;
        for (String fruit : transactionsMap.keySet()) {
            String transactions = getTransactionsWithoutPrefix(transactionsMap.get(fruit));
            List<String> split = Arrays.stream(transactions.split(",")).toList();

            int salesCount = split.stream().mapToInt(transaction -> Integer.parseInt(transaction.split(":")[1]))
                    .sum();

            if (max < salesCount) {
                max = salesCount;
                maxFruit = fruit;
            }
        }
        System.out.println("가장 많이 팔린 과일 : " + maxFruit + " - 총 " + max + "개 판매됨");
    }

    public void showTotalSales() {
        int totalSales = transactionsMap.values().stream()
                .flatMap(transactions -> Arrays.stream(transactions.substring(transactions.indexOf(",") + 1)
                        .split(",")))
                .mapToInt(transaction -> Integer.parseInt(transaction.split(":")[1]))
                .sum();

        System.out.println("과일의 총 판매량 : " + totalSales);
    }

    public void showTotalSalesBy(String fruit) {
        String transactions = getTransactionsWithoutPrefix(transactionsMap.get(fruit));
        if (transactions == null || transactions.isEmpty()) {
            System.out.println(fruit + "의 판매 이력이 없습니다.");
            return;
        }
        List<String> split = Arrays.stream(transactions.split(",")).toList();
        List<String> sortedTransactions = split.stream()
                .sorted(Comparator.comparing(s -> s.split(":")[0]))
                .collect(Collectors.toList());

        sortedTransactions.forEach(System.out::println);

        int totalSales = sortedTransactions.stream()
                .mapToInt(s -> Integer.parseInt(s.split(":")[1]))
                .sum();

        System.out.println(fruit + "의 총 판매 개수 : " + totalSales + "개");
    }

    private static String getTransactionsWithoutPrefix(String transactions) {
        return transactions.substring(transactions.indexOf(",") + 1);
    }
}
