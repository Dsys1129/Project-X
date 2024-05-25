package chap05.p9;

import java.io.File;
import java.util.Scanner;
// TODO 기본, 보너스 완료
// 폴더 경로 : src/chap05/p9/file
public class BiodomeForever09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DuplicateFileChecker duplicateFileChecker = new DuplicateFileChecker();
        System.out.println("중복 파일 검색기에 오신 걸 환영합니다.");
        System.out.print("탐색할 폴더를 입력하세요: ");
        String folderPath = scanner.nextLine();
        System.out.println();

        try {
            long beforeTime = System.nanoTime();
            File[] fileList = duplicateFileChecker.getFileList(folderPath);
            duplicateFileChecker.findDuplicateFiles(fileList);
            long afterTime = System.nanoTime();
            long diffTime = (afterTime - beforeTime) ;
            System.out.println("첫번째 시간 차이(nano) : " + diffTime);

            beforeTime = System.nanoTime();
            duplicateFileChecker.getFileList(folderPath);
            duplicateFileChecker.findDuplicateFilesBonus(fileList);
            afterTime = System.nanoTime();
            diffTime = (afterTime - beforeTime);
            System.out.println("보너스 시간 차이(nano) : " + diffTime);

        } catch (RuntimeException e) {
            System.out.println("오류가 발생하였습니다 : " + e.getMessage());
        }
    }
}
