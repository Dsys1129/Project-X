package chap01;

public class HelloBiodome07 {

    public static void main(String[] args) {
        if (args.length < 1 || args[0].isBlank()) {
            System.out.println("염기서열이 입력되지 않았습니다.");
            return;
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (String arg : args) {
            stringBuffer.append(arg).append(" ");
        }
        String inputDna = stringBuffer.toString().trim();
        System.out.println("[입력] " + inputDna);
        if (!inputDna.matches("^[CYJEH ]*$")) {
            System.out.println("염기서열은 C, J, H, E, Y 다섯가지로만 입력됩니다. 확인하고 다시 입력해주세요");
            return;
        }

        String result = DnaCompressor.compressDnaIgnoreWhitespace(inputDna.toCharArray()).toUpperCase();

        System.out.println("[출력] " + result);
        String bonusInput = "CCCCHHHH JJ   EEEEJJ";
        System.out.println("보너스 입력 -> " + bonusInput);
        String bonusResult = DnaCompressor.compressDnaWithWhitespace(bonusInput.toCharArray()).toUpperCase();
        System.out.println("보너스 출력 -> " + bonusResult);
    }

    static class DnaCompressor {

        private static String compressDnaIgnoreWhitespace(char[] dna) {
            int cnt = 1;
            char preCharacter = dna[0];
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 1; i < dna.length; i++) {
                if (dna[i] == ' ') {
                    continue;
                }
                if (dna[i] == preCharacter) {
                    cnt++;
                } else {
                    stringBuffer.append(preCharacter).append(cnt);
                    cnt = 1;
                    preCharacter = dna[i];
                }
            }
            stringBuffer.append(preCharacter).append(cnt);
            return stringBuffer.toString();
        }

        private static String compressDnaWithWhitespace(char[] dna) {
            int cnt = 1;
            char preCharacter = dna[0];
            StringBuffer stringBuffer = new StringBuffer();
            boolean preWhiteSpace = false;

            for (int i = 1; i < dna.length; i++) {
                if (dna[i] == ' ') {
                    preWhiteSpace = true;
                    continue;
                }
                if (dna[i] == preCharacter) {
                    cnt++;
                } else {
                    stringBuffer.append(preCharacter).append(cnt);
                    cnt = 1;
                    preCharacter = dna[i];
                    if (preWhiteSpace) {
                        stringBuffer.append(" ");
                    }
                    preWhiteSpace = false;
                }
            }
            stringBuffer.append(preCharacter).append(cnt);
            return stringBuffer.toString();
        }
    }
}
