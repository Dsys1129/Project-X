package chap05.p2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResearchLog {

    private String fileName;
    private String content;

    public ResearchLog(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
    }

    public void displayContent() {
        try {
            System.out.println(getDate() + " " + this.content);
        } catch (ParseException e) {
            System.out.println("날짜 정보를 추출할 수 없습니다.");
            e.printStackTrace();
        }
    }

    private String getDate() throws ParseException {
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMddHHmm");
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = originalFormat.parse(this.fileName.substring(0, 12));
        return targetFormat.format(date);
    }
}
