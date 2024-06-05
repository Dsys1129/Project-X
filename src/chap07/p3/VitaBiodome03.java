package chap07.p3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class VitaBiodome03 {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    handleClientRequest(client);
                } catch (Exception e) {
                    System.out.println("클라이언트 요청 처리 중 에러 발생: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("서버 실행 중 에러 발생: " + e.getMessage());
        }
    }

    private static void handleClientRequest(Socket client) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        String line = null;
        StringBuilder requestBuilder = new StringBuilder();
        while ((line = in.readLine()) != null && !line.isEmpty()) {
            requestBuilder.append(line + "\n");
        }

        String request = requestBuilder.toString();
        System.out.println(request);

        if (request.startsWith("GET / ")) {
            sendResponse(out, "200 OK", "text/html",
                    "<html><body><h1>Welcom to Vitamin Storage :)</h1></body></html>");
        } else if (request.startsWith("GET /socket")) {
            try {
                String hostAddress = client.getLocalAddress().getHostAddress();
                int port = client.getPort();
                String content = "<html><body><h1>" + hostAddress + " " + port + "</h1></body></html>";
                sendResponse(out, "200 OK", "text/html", content);
            } catch (Exception e) {
                sendResponse(out, "500 Internal Server Error", "text/html",
                        "<html><body><h1>Internal Server Error :o</h1></body></html>");
            }
        } else {
            sendResponse(out, "404 Not Found", "text/html",
                    "<html><body><h1>Page Not Found :(</h1></body></html>");
        }
    }

    private static void sendResponse(PrintWriter out, String status, String contentType, String content) {
        out.println("HTTP/1.1 " + status);
        out.println("Content-Type: " + contentType + "; charset=utf-8");
        out.println("Content-Length: " + content.getBytes().length);
        out.println();
        out.println(content);
    }
}