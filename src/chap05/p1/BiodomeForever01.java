package chap05.p1;

//TODO 일반, 보너스 완료

public class BiodomeForever01 {
    public static void main(String[] args) {
        if (args.length < 1 || args[0].isBlank()) {
            System.out.println("입력값이 올바르지 않습니다.");
            return;
        }

        String filePath = args[0];
        System.out.println("입력값 : " + filePath);
        ResearchLogManager researchLogManager = new ResearchLogManager();
        ResearchLog researchLog = researchLogManager.createResearchLog(filePath);
        researchLog.displayContent();

        System.out.println("\n=========== Bonus ==========");

        BonusResearchLog searchedResearchLog = researchLogManager.searchResearchLogBy("213012071130");
        searchedResearchLog.displayContent();
    }
}
