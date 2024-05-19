package chap05.p1;

public class ResearchLog {

    private String fileName;

    private String content;

    public ResearchLog(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public void displayContent() {
        System.out.println(this.content);
    }
}
