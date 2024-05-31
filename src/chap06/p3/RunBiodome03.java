package chap06.p3;

import java.util.Scanner;

//TODO 일반, 보너스 완료
public class RunBiodome03 {

    public static void main(String[] args) {
        FruitStore store = new FruitStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n과일 상점에 오신 것을 환영합니다!");
            System.out.println("1. 과일 판매하기");
            System.out.println("2. 과일 재고 추가하기");
            System.out.println("3. 모든 과일 재고 조회하기");
            System.out.println("4. 종료하기");
            System.out.println("5. Bonus => 최근 판매 기록 조회");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("판매할 과일의 이름을 입력하세요: ");
                    String sellFruitName = scanner.nextLine();
                    System.out.print("판매할 수량을 입력하세요: ");
                    int sellQuantity = scanner.nextInt();
                    store.sellFruit(sellFruitName, sellQuantity);
                    break;
                case 2:
                    System.out.print("재고를 추가할 과일의 이름을 입력하세요: ");
                    String addFruitName = scanner.nextLine();
                    System.out.print("추가할 수량을 입력하세요: ");
                    int addQuantity = scanner.nextInt();
                    store.addStock(addFruitName, addQuantity);
                    break;
                case 3:
                    store.showAllStock();
                    break;
                case 4:
                    store.saveFruitData();
                    System.out.println("모든 데이터가 저장되었습니다. 과일 상점 관리 시스템을 종료합니다!");
                    return;
                case 5:
                    System.out.println("===========Bonus=========");
                    System.out.print("최근 판매 기록을 조회할 과일 이름을 입력하세요 : ");
                    String searchFruitName = scanner.nextLine();
                    store.searchRecentTransactionBy(searchFruitName);
                    break;
                default:
                    System.out.println("올바른 메뉴를 선택해주세요.");
            }
        }
    }
}
