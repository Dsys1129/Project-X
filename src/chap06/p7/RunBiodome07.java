package chap06.p7;

import java.util.Scanner;

//TODO 기본, 보너스 완료
public class RunBiodome07 {

    public static void main(String[] args) {
        System.out.println("에너지 관리 시스템에 오신걸 환영합니다.");
        Scanner sc = new Scanner(System.in);
        EnergyManageCenter energyManageCenter = EnergyManageCenter.getInstance();

        while (true) {
            System.out.println("\n1. 중앙 에너지 센터와 3개 도시 에너지양 조회하기");
            System.out.println("2. 도시에 에너지 할당하기");
            System.out.println("3. 중앙 에너지 센터 에너지 보충하기");
            System.out.println("4. 프로그램 종료하기");
            System.out.print("메뉴 선택 : ");
            String input = sc.nextLine();

            switch (input) {
                case "1":
                    energyManageCenter.showAllCitiesEnergy();
                    break;
                case "2":
                    System.out.print("도시 이름 입력 : ");
                    String cityName = sc.nextLine();
                    System.out.print("할당할 에너지양 입력 : ");
                    int energy = Integer.parseInt(sc.nextLine());
                    energyManageCenter.assignEnergy(cityName, energy);
                    break;
                case "3":
                    System.out.print("보충할 에너지양 입력: ");
                    String replenishedEnergy = sc.nextLine();
                    energyManageCenter.replenishEnergy(Integer.parseInt(replenishedEnergy));
                    break;
                case "4":
                    return;
                default:
                    System.out.println("1 ~ 4의 값만 입력해주세요");
            }
        }
    }
}
