public class HelloBiodome06 {

    public static void main(String[] args) {

        // 두 개의 입력값이 들어오지 않으면 안내 메시지를 출력하고 프로그램을 종료한다.
        if (args.length < 2 || args.length > 2) {
            System.out.println("두 개의 유전자 코드를 입력해주세요.");
            return;
        }

        String dna1 = args[0].toLowerCase();
        String dna2 = args[1].toLowerCase();
        System.out.println(dna1 + " " + dna2);

        // length() 메서드를 이용해 입력 받은 두개 문자의 길이가 동일한지 확인한다.
        if (dna1.length() == dna2.length()) {
            // 길이가 동일한 경우, 각 문자를 순차적으로 비교하여 모든 문자가 일치하는지 확인한다.
            if (DnaChecker.isEqualDna(dna1, dna2)) {
                System.out.println("동일한 유전자 코드입니다.");
            } else {
                System.out.println("일치하지 않습니다.");
            }
        } else {
            System.out.println("일치하지 않습니다.");
        }

        // 첫 번째 유전자 코드가 두 번째 유전자 코드에 포함 여부를 확인하는 기능을 구현한다.
        if (DnaChecker.isContainsDna(dna1, dna2)) {
            System.out.println("보너스 문제 -> 부분적으로 포함됩니다.");
        } else {
            System.out.println("보너스 문제 -> 포함되지 않습니다.");
        }
    }

    static class DnaChecker {

        public static boolean isEqualDna(String dna1, String dna2) {
            for (int i = 0; i < dna1.length(); i++) {
                if (dna1.charAt(i) != dna2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        public static boolean isContainsDna(String dna1, String dna2) {
            for (int i = 0; i <= dna2.length() - dna1.length(); i++) {
                boolean check = true;
                for (int j = 0; j < dna1.length(); j++) {
                    if (dna2.charAt(i + j) != dna1.charAt(j)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    return true;
                }
            }
            return false;
        }
    }
}
