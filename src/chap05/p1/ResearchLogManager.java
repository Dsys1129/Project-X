package chap05.p1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class ResearchLogManager {

    private static final String FOLDER_PATH = "src/chap05/p1/file/";

    public ResearchLog createResearchLog(String filePath) {
        FileInputStream fileInputStream = null;
        ResearchLog researchLog = null;
        try {
            fileInputStream = new FileInputStream(FOLDER_PATH + filePath);
            byte[] bytes = new byte[fileInputStream.available()];
            int read = fileInputStream.read(bytes);
            if (read == -1) {
                throw new RuntimeException("파일이 비어있습니다.");
            }
            researchLog = new ResearchLog(filePath, new String(bytes));
        } catch (FileNotFoundException e) {
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("지정된 파일을 찾을 수 없습니다.");
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return researchLog;
    }

    public BonusResearchLog searchResearchLogBy(String createdDate) {
        FileInputStream fileInputStream = null;
        BonusResearchLog researchLog = null;
        File folder = new File(FOLDER_PATH);
        File searchedFile = Arrays.stream(folder.listFiles())
                .filter(file -> file.getName().split("_")[0].equals(createdDate))
                .findFirst().orElseThrow(() -> new RuntimeException("해당하는 파일이 없습니다."));

        try {
            fileInputStream = new FileInputStream(searchedFile);
            byte[] bytes = new byte[fileInputStream.available()];
            int read = fileInputStream.read(bytes);
            if (read == -1) {
                throw new RuntimeException("파일이 비어있습니다.");
            }
            researchLog = new BonusResearchLog(searchedFile.getName(), createdDate, new String(bytes));
        } catch (FileNotFoundException e) {
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("지정된 파일을 찾을 수 없습니다.");
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return researchLog;
    }
}
