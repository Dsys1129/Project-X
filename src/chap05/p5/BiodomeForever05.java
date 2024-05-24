package chap05.p5;


import java.io.*;

public class BiodomeForever05 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        EnvironmentManager environmentManager = new EnvironmentManager();
        System.out.println("환경 정보 관리 시스템에 오신 것을 환영합니다.");
        while (true) {
            System.out.println("\n1. 새로운 환경 데이터 입력");
            System.out.println("2. 모든 환경 데이터 조회");
            System.out.println("3. 날짜별 생명지수 조회");
            System.out.println("4. 프로그램 종료");
            System.out.println("5. Bonus 로그 스케일 평균 지수 조회");
            System.out.print("선택: ");
            String input = bufferedReader.readLine();
            if (!isValidInput(input)) {
                return;
            }

            switch (input) {
                case "1":
                    System.out.print("온도를 입력하세요 : ");
                    String temperature = bufferedReader.readLine();
                    if (!isNumber("온도", temperature)) {
                        break;
                    }
                    System.out.print("습도를 입력하세요 : ");
                    String humidity = bufferedReader.readLine();
                    if (!isNumber("습도", humidity)) {
                        break;
                    }
                    System.out.print("산소 농도를 입력하세요 : ");
                    String oxygen = bufferedReader.readLine();
                    if (!isNumber("산소농도", oxygen)) {
                        break;
                    }
                    System.out.print("측정 장소를 입력하세요 : ");
                    String place = bufferedReader.readLine();
                    Environment environment = new Environment(temperature, humidity, oxygen, place);
                    environmentManager.saveEnvironment(environment);
                    break;
                case "2":
                    System.out.println("모든 환경 데이터:");
                    environmentManager.loadAllEnvironment();
                    break;
                case "3":
                    System.out.println("날짜별 생명지수:");
                    environmentManager.loadLifeDataEnvironmentByDate();
                    break;
                case "4":
                    System.out.println("프로그램을 종료합니다. 감사합니다.");
                    return;
                case "5" :
                    System.out.println("========= Bonus =======");
                    environmentManager.loadLogAvg();
                    break;
            }
        }
    }
    private static boolean isValidInput(String input) {
        try {
            int inputNumber = Integer.parseInt(input);
            if (inputNumber < 1 || inputNumber > 5) {
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요");
            return false;
        }
        return true;
    }

    private static boolean isNumber(String data, String value) {
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값입니다. " + data + "는 숫자로 입력해주세요");
            return false;
        }
        return true;
    }
}
