package chap05.p4;

import java.io.*;

public class EnvironmentManager {

    private static String FOLDER_PATH = "src/chap05/p4/";
    private static String FILE_NAME = "environment_data.txt";

    public void saveEnvironment(Environment environment) {
        File file = new File(FOLDER_PATH + FILE_NAME);
        try(FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(environment.getDateTime());
            fileWriter.write(",");
            fileWriter.write(environment.getTemperature());
            fileWriter.write(",");
            fileWriter.write(environment.getHumidity());
            fileWriter.write(",");
            fileWriter.write(environment.getOxygen());
            fileWriter.write(",");
            fileWriter.write(environment.getPlace());
            fileWriter.write("\r\n");
            fileWriter.flush();
            System.out.println("데이터가 " + FILE_NAME + "에 저장되었습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadAllEnvironment() {
        File file = new File(FOLDER_PATH + FILE_NAME);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
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

    public void loadAllOxygen() {
        File file = new File(FOLDER_PATH + FILE_NAME);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String[] split = str.split(",");
                System.out.println(split[0] + " - " + split[3] + " - " + split[4]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
