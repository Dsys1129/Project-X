package chap06.p9;

import java.util.Scanner;

//TODO 기본, 보너스 완료
public class RunBiodome09 {
    private static final String[] regions = {"테라노바", "루미나베이", "플로우브릿지", "루미노엣지"};
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n수자원 관리 시스템에 오신걸 환영합니다.");
            System.out.println("1. 중앙 수자원 센터와 4개 도시 보유 물양 조회하기");
            System.out.println("2. 도시에 물 할당하기");
            System.out.println("3. 프로그램 종료하기");
            System.out.println("4. Bonus >> 도시에 물 할당하기");
            System.out.print("메뉴를 선택하세요: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("중앙 수자원 센터의 현재 물양: " +
                            CentralWaterCenter.getInstance().getWaterAmount());
                    for (String region : regions) {
                        System.out.println(region + " 이 가지고 있는 물의양 : " +
                                CentralWaterCenter.getInstance().printRegionWaterAmount(region));
                    }
                    break;
                case "2":
                    allocateWater();
                    break;
                case "3":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                case "4":
                    allocateWaterBonus();
                    break;
            }
        }
    }

    private static void allocateWater() {
        WaterRequestThread[] threads = new WaterRequestThread[4];
        for (int i = 0; i < regions.length; i++) {
            System.out.print(regions[i] + "에 필요한 물의 양을 입력하세요: ");
            int waterRequestAmount = Integer.parseInt(scanner.nextLine());
            if (waterRequestAmount < 0) {
                System.out.println("마이너스값이 입력되었습니다. 다시 한번 확인해주세요.");
                return;
            }
            threads[i] = new WaterRequestThread(regions[i], waterRequestAmount);
        }
        startAndJoinThreads(threads);
    }

    private static void startAndJoinThreads(WaterRequestThread[] threads) {
        System.out.println("=====물 분배 시작======");
        for (WaterRequestThread thread : threads) {
            thread.start();
        }
        for (WaterRequestThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("최종 남은 물의 양: " +
                CentralWaterCenter.getInstance().getWaterAmount());
    }

    private static void allocateWaterBonus() {
        WaterRequestThreadBonus[] threads = new WaterRequestThreadBonus[4];
        for (int i = 0; i < regions.length; i++) {
            threads[i] = new WaterRequestThreadBonus(regions[i], 1000);
        }
        startAndJoinThreadsBonus(threads);
    }

    private static void startAndJoinThreadsBonus(WaterRequestThreadBonus[] threads) {
        System.out.println("=====물 분배 시작======");
        for (WaterRequestThreadBonus thread : threads) {
            thread.start();
        }
        for (WaterRequestThreadBonus thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("최종 남은 물의 양: " + BonusCentralWaterCenter.getInstance().getWaterAmount());
    }
}
