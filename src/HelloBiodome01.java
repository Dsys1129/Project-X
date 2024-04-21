public class HelloBiodome01 {

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 1) {
            System.out.println("입력의 개수가 올바르지 않습니다.");
            return;
        }

        String inputName = args[0];
        StringBuilder stringBuilder = new StringBuilder();

        if (inputName.isBlank()) {
            System.out.println("재입력 해 주세요");
            return;
        }
        if (args[0].length() < 10)
            stringBuilder
                    .append(inputName)
                    .append(" - > ")
                    .append("어서오세요")
                    .append(" ")
                    .append("\"")
                    .append(inputName)
                    .append("\"")
                    .append("님");
        System.out.println(stringBuilder);

        stringBuilder = new StringBuilder();

        // 보너스 문제
        String bonusInput = "일이삼사오육칠팔구십일이삼사오육칠팔구십";
        String extractedName = NameExtractor.extractName(bonusInput.toCharArray(), "", 0);
        stringBuilder
                .append(bonusInput)
                .append(" - > ")
                .append("보너스 문제 입니다. 어서오세요")
                .append(" ")
                .append("\"")
                .append(extractedName)
                .append("\"")
                .append("님");
        System.out.println(stringBuilder);
    }

    /**
     * Bonus
     * 긴 이름 문자열 중 처음부터 10글자를 추출하는 역할을 하는 클래스
     */
    static class NameExtractor {
        private static final int LIMIT_NAME_LENGTH = 10;

        // 재귀 호출로 처음부터 한 글자씩 추출하는 메서드
        private static String extractName(char[] name, String result, int index) {
            if (index == LIMIT_NAME_LENGTH) {
                return result;
            }
            result += name[index];
            return extractName(name, result, index + 1);
        }
    }
}
