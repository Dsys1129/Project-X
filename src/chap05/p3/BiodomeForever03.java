package chap05.p3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//TODO 기본, 보너스 완료
public class BiodomeForever03 {
    public static void main(String[] args) {
        String folderName = "file";
        ResearchLogExtractor researchLogExtractor = new ResearchLogExtractor(folderName);

        String folderPrefix = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhss"));
        researchLogExtractor.extractAndSave(folderPrefix + "_Lumino_ADR.txt");
    }
}
