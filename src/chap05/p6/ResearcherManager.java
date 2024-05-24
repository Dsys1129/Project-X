package chap05.p6;

import java.io.*;
import java.util.HashMap;
import java.util.regex.Pattern;

public class ResearcherManager {

    private static String pattern = "LUMI-\\d{4}-\\d{2}:\\d{3}";
    private HashMap<String, Integer> yearCountMap = new HashMap<>();
    private static final String FOLDER_PATH = "src/chap05/p6/";
    private static final String FILE_NAME = "researchers_data.txt";


    public ResearcherManager() {
        this.yearCountMap = createYearCountMap();
    }

    public void registerResearcher(Researcher researcher) {
        if (isExistsName(researcher.getName())) {
            return;
        }

        String registerYear = String.valueOf(researcher.getCreatedAt().getYear());
        researcher.generateId(yearCountMap.getOrDefault(registerYear, 0) + 1);

        File file = new File(FOLDER_PATH + FILE_NAME);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.append(researcher.getId())
                    .append(",")
                    .append(researcher.getName())
                    .append(",")
                    .append(researcher.getCreatedAt().toString())
                    .append(",")
                    .append(researcher.getPosition())
                    .append("\r\n");
            fileWriter.flush();
            yearCountMap.put(registerYear, yearCountMap.getOrDefault(registerYear, 0) + 1);
            System.out.println("연구원 정보가 성공적으로 등록되었습니다!");
            System.out.println("생성된 연구원 ID : " + researcher.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadAllResearchers() {
        File file = getFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchResearcherBy(String id) {
        if (!Pattern.matches(pattern, id)) {
            System.out.println("검색할 ID의 형식이 올바르지 않습니다.");
            return;
        }
        File file = getFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String[] split = str.split(",");
                if (split[0].equals(id)) {
                    System.out.println("연구원 정보:");
                    System.out.println("-------------------------");
                    System.out.println(str);
                    System.out.println("-------------------------");
                    return;
                }
            }
            System.out.println("에러 : 해당 ID를 가진 연구원 정보가 존재하지 않습니다.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isExistsName(String name) {
        File file = getFile();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String[] split = str.split(",");
                if (split[1].equals(name)) {
                    System.out.println(name + "은 " + split[0] + "에 이미 등록되었습니다.");
                    return true;
                }
            }
            return false;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static File getFile() {
        File file = new File(FOLDER_PATH + FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return file;
    }

    private HashMap<String, Integer> createYearCountMap() {
        File file = getFile();
        HashMap<String, Integer> createYearContMap = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String[] split = str.split(",");
                String year = split[2].substring(0, 4);
                createYearContMap.put(year, createYearContMap.getOrDefault(year, 0) + 1);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return createYearContMap;
    }
}
