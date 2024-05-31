package chap06.p2;

import java.util.Scanner;

public class RunBiodome02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EnergyDistributor distributor = new EnergyDistributor();
        System.out.println("\n바이오도메 에너지 관리 시스템에 오신 것을 환영합니다.");
        System.out.println("1. 전체 에너지 조회하기");
        System.out.println("2. 특정 구역 에너지 할당하기");
        System.out.println("3. 구역별 에너지 조회하기");
        System.out.println("4. 종료하기");
        while (true) {
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    distributor.showTotalEnergy();
                    break;
                case 2:
                    System.out.print("할당하려는 구역 이름을 입력하세요: ");
                    String place = scanner.nextLine();
                    System.out.print("할당하려는 에너지량을 입력하세요: ");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    distributor.allocateEnergy(place, amount);
                    break;
                case 3:
                    distributor.showPlaceEnergy();
                    break;
                case 4:
                    System.out.println("바이오도메 에너지 관리 시스템을 종료합니다. 감사합니다.");
                    return;
                default:
                    System.out.println("1번에서 4번 메뉴를 선택해주세요");
            }
        }
    }
}

