package chap05.p9;

import java.io.*;

public class DuplicateFileChecker {

    public File[] getFileList(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("올바르지 않은 경로입니다.");
        }

        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            throw new IllegalArgumentException("폴더가 비어있습니다.");
        }
        return files;
    }

    public void findDuplicateFiles(File[] fileList) {
        for (int i = 0; i < fileList.length; i++) {
            for (int j = i + 1; j < fileList.length; j++) {
                if (isDuplicate(fileList[i], fileList[j])) {
                    System.out.println(fileList[i] + "파일과 " + fileList[j] + "파일은 동일한 파일입니다.");
                    return;

                }
            }
        }
        System.out.println("중복되는 파일이 없습니다.");
    }

    private boolean isDuplicate(File file1, File file2) {
        try (FileInputStream fileInputStream1 = new FileInputStream(file1);
             FileInputStream fileInputStream2 = new FileInputStream(file2)) {
            int fileByte1 = 0;
            int fileByte2 = 0;
            while ((fileByte1 = fileInputStream1.read()) != -1 && (fileByte2 = fileInputStream2.read()) != -1) {
                if (fileByte1 != fileByte2) {
                    return false;
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는 도중 오류가 발생하였습니다.");
        }
    }

    public void findDuplicateFilesBonus(File[] fileList) {
        for (int i = 0; i < fileList.length; i++) {
            for (int j = i + 1; j < fileList.length; j++) {
                if (isDuplicateBonus(fileList[i], fileList[j])) {
                    System.out.println(fileList[i] + "파일과 " + fileList[j] + "파일은 동일한 파일입니다.");
                    return;

                }
            }
        }
        System.out.println("중복되는 파일이 없습니다.");
    }

    private boolean isDuplicateBonus(File file1, File file2) {
        if (file1.length() != file2.length()) {
            return false;
        }

        try (FileInputStream fileInputStream1 = new FileInputStream(file1);
             FileInputStream fileInputStream2 = new FileInputStream(file2)) {
            int fileByte1 = 0;
            int fileByte2 = 0;
            while ((fileByte1 = fileInputStream1.read()) != -1 && (fileByte2 = fileInputStream2.read()) != -1) {
                if (fileByte1 != fileByte2) {
                    return false;
                }
            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            throw new RuntimeException("파일을 읽는 도중 오류가 발생하였습니다.");
        }
    }
}
