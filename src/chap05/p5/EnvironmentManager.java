package chap05.p5;


import java.io.*;

public class EnvironmentManager {

    private static String FOLDER_PATH = "src/chap05/p5/";
    private static String FILE_NAME = "environment_data.txt";

    public void saveEnvironment(Environment environment) {
        File file = new File(FOLDER_PATH + FILE_NAME);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file, true))) {
            objectOutputStream.writeObject(environment);
            objectOutputStream.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadLifeDataEnvironmentByDate() {
        File file = new File(FOLDER_PATH + FILE_NAME);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int index = 1;
            while (true) {
                try {
                    // InputStream을 계속 생성해줘야 invalid type code: AC가 발생하지 않는다.
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Environment environment = (Environment) objectInputStream.readObject();
                    System.out.print(index++ + ". ");
                    environment.displayLifeData(EnvironmentDataAnalyzer.calculateH(environment));
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadAllEnvironment() {
        File file = new File(FOLDER_PATH + FILE_NAME);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int index = 1;
            while (true) {
                try {
                    // InputStream을 계속 생성해줘야 invalid type code: AC가 발생하지 않는다.
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Environment environment = (Environment) objectInputStream.readObject();
                    System.out.print(index++ + ". ");
                    environment.displayInfo();
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void loadLogAvg() {
        File file = new File(FOLDER_PATH + FILE_NAME);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int index = 1;
            while (true) {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Environment environment = (Environment) objectInputStream.readObject();
                    System.out.print(index++ + ". ");
                    System.out.println(environment.getDateTime() + ", " + environment.getPlace() +  " : " + EnvironmentDataAnalyzer.calculateLogAvg(environment));
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}