package chap05.p8;

import java.io.*;
import java.util.*;

public class EnvironmentDataManager {

    private static final String FILE_NAME = "environment_data_Lake_original.txt";
    private static final String FOLDER_PATH = "src/chap05/p8/file/";
    private List<EnvironmentData> environmentDataList;
    private BinarySearchTree binarySearchTree;

    public EnvironmentDataManager() {
        this.environmentDataList = initEnvironmentDataList();
        binarySearchTree = initBinarySearchTree();
    }


    public void updateEnvironmentData(Node node, EnvironmentData environmentData) {
        binarySearchTree.updateNode(node, environmentData);
        updateEnvironmentDataList(environmentData);
        updateFile();
    }

    public List<EnvironmentData> searchRange(String startDate, String endDate) {
        return binarySearchTree.searchRange(startDate, endDate);
    }

    private BinarySearchTree initBinarySearchTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        List<EnvironmentData> list = new ArrayList<>(environmentDataList);
        Collections.shuffle(list);
        for (EnvironmentData environmentData : list) {
            binarySearchTree.add(environmentData);
        }

        return binarySearchTree;
    }

    private List<EnvironmentData> initEnvironmentDataList() {
        List<EnvironmentData> environmentDataList = new ArrayList<>();
        File file = new File(FOLDER_PATH + FILE_NAME);

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                environmentDataList.add(new EnvironmentData(split[0], split[1], split[2], split[3]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return environmentDataList;
    }

    private void updateEnvironmentDataList(EnvironmentData environmentData) {
        for (int i = 0; i < environmentDataList.size(); i++) {
            if (environmentDataList.get(i).getDate().equals(environmentData.getDate())) {
                environmentDataList.set(i, environmentData);
                break;
            }
        }
    }

    private void updateFile() {
        File file = new File(FOLDER_PATH + "environment_data_Lake.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (EnvironmentData data : environmentDataList) {
                bufferedWriter.append(data.getDate())
                        .append(",")
                        .append(data.getTemperature())
                        .append(",")
                        .append(data.getHumidity())
                        .append(",")
                        .append(data.getOxygen())
                        .append("\r\n");
                bufferedWriter.flush();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BinarySearchTree getBinarySearchTree() {
        return binarySearchTree;
    }
}
