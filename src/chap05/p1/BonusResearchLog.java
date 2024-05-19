package chap05.p1;

public class BonusResearchLog {

    private String fileName;
    private String createdDate;
    private String content;

    public BonusResearchLog(String fileName, String createdDate, String content) {
        this.fileName = fileName;
        this.createdDate = createdDate;
        this.content = content;
    }

    public void displayContent() {
        System.out.println(this.content);
    }
}
