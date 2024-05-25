package chap05.p7;

import java.util.Scanner;

public class BiodomeForever07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EnvironmentManager manager = new EnvironmentManager();

        System.out.println("환경 데이터 검색 프로그램을 시작합니다.");
        System.out.println("1. 환경 정보 검색");
        System.out.println("Bonus >> 2. 환경 정보 저장");
        System.out.println("3. 프로그램 종료");
        System.out.print("메뉴를 선택해주세요 : ");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                System.out.print("검색하고 싶은 날짜를 입력하세요: ");
                String searchDate = scanner.nextLine();
                manager.searchEnvironmentBy(searchDate);
                break;
            case "2":
                System.out.print("저장할 날짜를 입력해주세요 : ");
                String date = scanner.nextLine();
                manager.saveEnvironmentBy(date);
                break;
            case "3":
                System.out.println("프로그램을 종료합니다.");
                break;
            default:
                System.out.println("잘못된 선택입니다.");
        }
    }
}
