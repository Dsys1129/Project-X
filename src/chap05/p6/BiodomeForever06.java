package chap05.p6;

import java.util.Scanner;

// TODO 기본문제 , 보너스 문제 완료
public class BiodomeForever06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResearcherManager researcherManager = new ResearcherManager();

        while (true) {
            System.out.println("-----------------------------------");
            System.out.println("연구원 정보 관리 시스템");
            System.out.println("-----------------------------------");
            System.out.println("1. 새로운 연구자 등록");
            System.out.println("2. 모든 연구자 조회");
            System.out.println("3. 조건 기반 연구자 검색");
            System.out.println("4. 프로그램 종료");
            System.out.println("-----------------------------------");
            System.out.print("선택하세요 (1-4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("연구원의 이름을 입력하세요: ");
                    String name = scanner.nextLine();
                    System.out.print("연구원의 담당 위치를 입력하세요: ");
                    String position = scanner.nextLine();
                    Researcher researcher = new Researcher(name, position);
                    researcherManager.registerResearcher(researcher);
                    break;
                case "2":
                    researcherManager.loadAllResearchers();
                    break;
                case "3":
                    System.out.print("검색할 연구원의 ID를 입력하세요: ");
                    String id = scanner.nextLine();
                    researcherManager.searchResearcherBy(id);
                    break;
                case "4":
                    System.out.println("프로그램을 종료합니다. 감사합니다.");
                    return;
                default:
                    System.out.println("올바른 선택이 아닙니다. 다시 선택해주세요.");
            }
        }
    }
}
