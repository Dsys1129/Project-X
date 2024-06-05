package chap07.p1;

import java.net.InetAddress;
import java.net.URL;
import java.util.Scanner;

public class VitaBiodome01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("URL 주소를 입력하세요: ");
        String urlInput = scanner.nextLine();

        try {
            URL url = new URL(urlInput);

            // URL 객체의 정보를 출력
            System.out.println("url.getAuthority():" + url.getAuthority());
            System.out.println("url.getContent():" + url.getContent().toString());
            System.out.println("url.getDefaultPort():" + url.getDefaultPort());
            System.out.println("url.getPort():" + url.getPort());
            System.out.println("url.getFile():" + url.getFile());
            System.out.println("url.getHost():" + url.getHost());
            System.out.println("url.getPath():" + url.getPath());
            System.out.println("url.getProtocol():" + url.getProtocol());
            System.out.println("url.getQuery():" + (url.getQuery() != null ? url.getQuery() : "null"));
            System.out.println("url.getRef():" + (url.getRef() != null ? url.getRef() : "null"));
            System.out.println("url.getUserInfo():" + (url.getUserInfo() != null ? url.getUserInfo() : "null"));
            System.out.println("url.toExternalForm():" + url.toExternalForm());
            System.out.println("url.toURI():" + url.toURI().toString());

            System.out.println("================= 보너스 ============");
            InetAddress inetAddress = InetAddress.getByName(url.getHost());
            System.out.println("호스트 이름: " + url.getHost());
            System.out.println("IP 주소: " + inetAddress.getHostAddress());

        } catch (Exception e) {
            System.out.println("URL 분석 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}