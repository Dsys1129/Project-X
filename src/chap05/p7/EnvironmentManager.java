package chap05.p7;

import java.io.*;

public class EnvironmentManager {
    private static final String FOLDER_PATH = "src/chap05/p7/file/";
    private static final String FILE_NAME = "environment_data_Lumino.txt";

    public void searchEnvironmentBy(String date) {
        String[] dateSplit = date.split(" ");
        File file = new File(FOLDER_PATH + FILE_NAME);

        try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {
            String line = null;
            while ((line = randomAccessFile.readLine()) != null) {
                if (line.startsWith(date)) {
                    String[] lineSplit = line.split(",");
                    Environment findEnvironment = new Environment(dateSplit[0], dateSplit[1], lineSplit[1], lineSplit[2], lineSplit[3]);
                    System.out.println("검색 결과 : " + findEnvironment.getEnvironmentInfo());
                    return;
                }
            }
            System.out.println("해당 날짜의 데이터는 존재하지 않습니다.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveEnvironmentBy(String date) {
        File file = new File(FOLDER_PATH + FILE_NAME);

        try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r")) {

            String line = null;
            String newFileName = date + "_environment_data.txt";
            File newFile = new File(FOLDER_PATH + newFileName);
            FileWriter fileWriter = new FileWriter(newFile);
            while ((line = randomAccessFile.readLine()) != null) {
                if (line.startsWith(date)) {
                    String[] lineSplit = line.split(",");
                    String[] dateSplit = lineSplit[0].split(" ");
                    Environment environment = new Environment(dateSplit[0], dateSplit[1], lineSplit[1], lineSplit[2], lineSplit[3]);
                    fileWriter.append(environment.getEnvironmentInfo());
                    fileWriter.append("\r\n");
                }
            }
            fileWriter.flush();
            fileWriter.close();
            System.out.println(newFileName + "파일이 생성되었습니다.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
