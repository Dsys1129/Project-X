package chap06.p4;

import java.util.Scanner;

public class RunBiodome04 {

    public static void main(String[] args) {
        FruitStore store = new FruitStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n과일 상점에 오신 것을 환영합니다!");
            System.out.println("1. 모든 과일 재고 조회하기");
            System.out.println("2. 가장 많이 팔린 과일 조회하기");
            System.out.println("3. 총 판매 과일 수 조회하기");
            System.out.println("4. 과일별 평균 판매 개수 조회하기");
            System.out.println("5. Bonus >> 과일별 판매 조회하기");
            System.out.println("6. 종료하기");
            System.out.print("메뉴를 선택하세요: ");
            String menu = scanner.nextLine();

            switch (menu) {
                case "1":
                    store.showAllStock();
                    break;
                case "2":
                    store.showMostSoldFruit();
                    break;
                case "3":
                    store.showTotalSales();
                    break;
                case "4":
                    store.showAverages();
                    break;
                case "5":
                    System.out.print("조회할 과일의 이름을 입력해주세요 : ");
                    String fruit = scanner.nextLine();
                    store.showTotalSalesBy(fruit);
                    break;
                case "6":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 메뉴를 선택해주세요.");
            }
        }
    }
}
