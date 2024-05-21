package chap05.p3;

import chap05.p3.exception.NoDataAvailableException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;;

public class ResearchLogExtractor {

    private static final String FOLDER_PATH = "src/chap05/p3/";
    private List<ResearchLog> researchLogList;

    public ResearchLogExtractor(String folderPath) {
        this.researchLogList = extractResearchLogs(folderPath);
    }

    private List<ResearchLog> extractResearchLogs(String folderName) {

        File[] listOfFiles = getFiles(FOLDER_PATH + folderName);
        List<ResearchLog> result = new ArrayList<>();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    byte[] data = new byte[(int) file.length()];
                    fileInputStream.read(data);
                    String content = new String(data, StandardCharsets.UTF_8);

                    if (!content.contains("Name.") || !content.contains("ADR.")){
                        System.out.println(file.getName() + " 는 식물명 또는 주소 정보가 누락되었습니다.");
                        continue;
                    }
                    result.add(new ResearchLog(file.getName(), content));
                } catch (IOException e) {
                    System.out.println("파일을 읽는 도중 오류가 발생하였습니다.");
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return result;
    }

    public void extractAndSave(String outputPath) {
        if (researchLogList.isEmpty()) {
            return;
        }
        Set<String> set = new HashSet<>();

        StringBuilder builder = new StringBuilder();
        for (ResearchLog researchLog : researchLogList) {
            String[] lines = researchLog.getContent().split("\n");
            String plantName = null;
            String plantAddr = null;
            for (String line : lines) {
                if (line.startsWith("Name.")) {
                    plantName = line.substring(line.indexOf(" ") + 1).trim();
                }
                if (line.startsWith("ADR.")) {
                    plantAddr = line.substring(line.indexOf(" ") + 1).trim();
                }
            }
            String key = plantName + " - " + plantAddr;

            if (set.contains(key)) {
                System.out.println("bonus >> " + key + " 는 중복입니다. 파일 저장에서 제외합니다.");
            }

            if (!set.contains(key)) {
                builder.append(plantName).append(" - ").append(plantAddr).append("\n");
                set.add(key);
            }
        }

        try (FileOutputStream fos = new FileOutputStream(FOLDER_PATH + outputPath)) {
            fos.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File[] getFiles(String folderPath) {
        File folder = null;
        File[] listOfFiles = null;
        try {
            folder = new File(folderPath);

            if (!folder.exists() || !folder.isDirectory()) {
                throw new FileNotFoundException("폴더의 경로가 잘못되었습니다.");
            }

            listOfFiles = folder.listFiles();

            if (listOfFiles == null || listOfFiles.length == 0) {
                throw new NoDataAvailableException("분석할 파일이 없습니다.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("폴더 경로가 잘못되었습니다.");
            e.printStackTrace();
        } catch (NoDataAvailableException e) {
            e.printStackTrace();
        }
        return listOfFiles;
    }
}
