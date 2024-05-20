package chap05.p2;

// TODO 기본 문제, 보너스 완료
public class BiodomeForever02 {
    public static void main(String[] args) {
        if (args.length < 1 || args[0].isBlank()) {
            System.out.println("입력값이 올바르지 않습니다.");
            return;
        }

        String filePath = args[0];
        ResearchLogManager researchLogManager = new ResearchLogManager();
        ResearchLog researchLog = researchLogManager.createResearchLog(filePath);
        researchLog.displayContent();
    }
}
