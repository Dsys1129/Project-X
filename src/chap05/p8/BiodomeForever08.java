package chap05.p8;

import java.util.*;

public class BiodomeForever08 {
    private static Scanner sc;
    private static EnvironmentDataManager environmentDataManager;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        environmentDataManager = new EnvironmentDataManager();
        System.out.println("환경 정보 검색 프로그램에 오신 것을 환영합니다!");
        System.out.println("1. 기본 문제");
        System.out.println("2. 보너스 문제");
        System.out.println("3. 종료");
        String input = sc.nextLine();
        switch (input) {
            case "1":
                basicProblem();
                break;
            case "2":
                bonusProblem();
                break;
            case "3":
                return;
            default:
                System.out.println("잘못된 입력입니다.");
        }
    }

    private static void basicProblem() {
        System.out.print("검색하고 싶은 날짜를 입력하세요 : ");
        String date = sc.nextLine();
        Node searchedNode = environmentDataManager.getBinarySearchTree().search(date);
        if (searchedNode == null) {
            System.exit(0);
        }

        System.out.print("데이터를 수정하시겠습니까? (Y/N): ");
        String updateInput = sc.nextLine();

        if (!updateInput.equals("Y")) {
            System.exit(0);
        }

        System.out.println("새로운 데이터 값을 입력하세요");
        String newDataInput = sc.nextLine();
        String[] split = newDataInput.split(",");
        EnvironmentData newEnvironmentData = new EnvironmentData(searchedNode.getValue().getDate(), split[0], split[1], split[2]);
        environmentDataManager.updateEnvironmentData(searchedNode, newEnvironmentData);
        System.out.println("데이터 수정 완료!");
        System.out.println("날짜 " + searchedNode.getDate() + "수정된 데이터 : " + newEnvironmentData.getEnvironmentInfo());
    }

    private static void bonusProblem() {
        System.out.println("검색하고 싶은 날짜 범위를 입력하세요.");
        System.out.print("시작 날짜: ");
        String startDate = sc.nextLine();
        System.out.print("종료 날짜: ");
        String endDate = sc.nextLine();

        if (endDate.compareTo(startDate) < 0) {
            System.out.println("종료 날짜는 시작 날짜보다 앞일 수 없습니다.");
            System.exit(0);
        }

        List<EnvironmentData> results = environmentDataManager.searchRange(startDate, endDate);

        if (results.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
            System.exit(0);
        }

        System.out.println("검색 결과:");
        System.out.println("--------------------------");
        System.out.println("날짜와 시간        | 온도 | 습도 | 산소 농도");
        System.out.println("--------------------------");
        for (EnvironmentData data : results) {
            System.out.println(data.getDate() + " | " + data.getTemperature() + "°C | " + data.getHumidity() + "% | " + data.getOxygen() + "%");
        }
        System.out.println("--------------------------");
        System.out.println("검색이 완료되었습니다.");
    }
}
