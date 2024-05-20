package chap05.p2;


import chap05.p2.exception.EmptyFileException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ResearchLogManager {

    private static final String FOLDER_PATH = "src/chap05/p2/file/";

    public ResearchLog createResearchLog(String filePath) {
        FileInputStream fileInputStream = null;
        ResearchLog researchLog = null;
        try {
            fileInputStream = new FileInputStream(FOLDER_PATH + filePath);
            byte[] bytes = new byte[fileInputStream.available()];
            int read = fileInputStream.read(bytes);
            if (read == 0) {
                throw new EmptyFileException("파일이 비어있습니다.");
            }
            researchLog = new ResearchLog(filePath, new String(bytes));
        } catch (FileNotFoundException e) {
            System.out.println("존재하지 않는 파일입니다. 파일 이름을 다시 확인해주세요.");
            e.printStackTrace();
        } catch (EmptyFileException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            System.out.println("보안이나 정책, 권한 문제로 파일에 엑세스 할 수 없습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("파일 처리 중 오류가 발생하였습니다.");
            e.printStackTrace();
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
