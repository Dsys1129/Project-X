import java.io.IOException;

public class HelloBiodome05 {

    public static void main(String[] args) throws IOException {
        int[] gAndH = getGAndH();
        int g = gAndH[0];
        int h = gAndH[1];
        System.out.println("세번째 수식의 값 : " + getResult(g, h));
        System.out.println("보너스 문제 : " + getBonusResult(g, h));
    }

    // 4bit로 표현할 수 있는 정수의 범위는 -8 ~ 7
    private static int[] getGAndH() {
        for (int g = -8; g <= 7; g++) {
            for (int h = -8; h <= 7; h++) {
                if ((g & 1 >> g << 2 | h + g ^ h) == 1 && (g % 2 << h >> g | 1 & 0 ^ 0) == 2) {
                    return new int[]{g, h};
                }
            }
        }
        return null;
    }

    private static int getResult(int g, int h) {
        return (h * h + g) * (h << h) + (g << g);
    }

    private static int getBonusResult(int g, int h) {
        // 8 + 2 + 12 + 2 - (-3) + 12 + 3 = 42
        // (2 * 2^2) + (2 * 1) + (3 * 2^2) + (2) - (-3) + (3 * 2^2) + 3
        return (h << 2) + (h * g) + (++h << 2) + (h == 1 ? 1 : 2) - (-h) + (h << 2) + h;
    }
}