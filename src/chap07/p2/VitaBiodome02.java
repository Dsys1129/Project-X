package chap07.p2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VitaBiodome02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("URL을 입력하세요 : ");
        String urlInput = sc.nextLine();
        basicProblem(urlInput);
        System.out.println("\n================ Bonus ==================");
        bonusProblem(urlInput);

    }

    private static void basicProblem(String urlInput) {
        try {
            URL url = new URL(urlInput);
            try(InputStream inputStream = url.openStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {

                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void bonusProblem(String urlInput) {
        try {
            URL url = new URL(urlInput);
            try (InputStream inputStream = url.openStream();
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                Pattern pattern = Pattern
                        .compile("<meta\\s+http-equiv=\"([^\"]*)\"\\s+content=\"([^\"]*)\"\\s*/?>",
                                Pattern.CASE_INSENSITIVE);

                String line = null;
                boolean hasMetaTag = false;
                while ((line = bufferedReader.readLine()) != null) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        System.out.println(matcher.group(1) + " : " + matcher.group(2));
                        hasMetaTag = true;
                    }
                }
                if (!hasMetaTag) {
                    System.out.println("<meta> 태그가 존재하지 않습니다.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
