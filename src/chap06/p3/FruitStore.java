package chap06.p3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.stream.Stream;

public class FruitStore {

    private static final String FOLDER_PATH = "src/chap06/p3/file/";
    private static final String FILE_NAME = "fruit_data_original.csv";

    private HashMap<String, Integer> stockMap = new HashMap<>();
    private HashMap<String, String> transaction = new HashMap<>();

    public FruitStore() {
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
                transaction.put(split[0], split[2]);
            }
        }
    }

    public void saveFruitData() {
        StringBuilder sb = new StringBuilder();
        sb.append("과일명,재고량,최근 판매 정보").append("\n");
        for (String fruit : stockMap.keySet()) {
            sb.append(fruit).append(",").append(stockMap.get(fruit)).append(",").append(transaction.get(fruit)).append("\n");
        }
        byte[] bytes = sb.toString().getBytes(StandardCharsets.UTF_8);
        try {
            Files.write(Paths.get(FOLDER_PATH + "test.txt"), bytes);
        } catch (IOException e) {
            throw new RuntimeException("파일을 저장하는데 오류가 발생하였습니다.");
        }
    }

    public void searchRecentTransactionBy(String fruit) {
        String recentTransaction = this.transaction.get(fruit);
        if (recentTransaction.isBlank()) {
            System.out.println("해당하는 과일이 없습니다.");
            return;
        }
        String[] split = recentTransaction.split(":");
        System.out.println(split[0] + " " + split[1] + "개");
    }

    // 재고 조회 메서드 : entrySet().stream()을 사용하여 모든 항목에 대한 스트림을 얻는다.
    public void showAllStock() {
        System.out.println("모든 과일 재고 조회: ");
        stockMap.entrySet().stream().forEach((fruit) ->
                System.out.println(fruit.getKey() + "-" + fruit.getValue() + "개"));
    }

    public void sellFruit(String fruit, int quantity) {
        if (quantity < 0) {
            System.out.println("개수는 음수일 수 없습니다.");
            return;
        }

        Integer stock = stockMap.get(fruit);
        if (stock == null) {
            System.out.println("해당하는 과일이 없습니다.");
            return;
        }

        if (stock < quantity) {
            System.out.println("재고가 모자랍니다.");
            return;
        }
        transaction.put(fruit, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + ":" + quantity);
        stockMap.put(fruit, stockMap.get(fruit) - quantity);
        System.out.println(fruit + " " + quantity + "개가 판매되었습니다.");
    }

    public void addStock(String fruit, int quantity) {
        if (quantity < 0) {
            System.out.println("개수는 음수일 수 없습니다.");
            return;
        }

        Integer stock = stockMap.get(fruit);
        if (stock == null) {
            System.out.println("해당하는 과일이 없습니다.");
            return;
        }

        stockMap.put(fruit, stock + quantity);
        System.out.println(fruit + " 재고가 " + quantity + "개 추가되었습니다.");
    }
}
