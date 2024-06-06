package chap07.p4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class VitaBiodome04 {
    private static HashMap<String, Fruit> fruitHashMap = new HashMap<>();
    private static int requestCount;

    public static void main(String[] args) {
        // 구매 가능한 과일은 사과와 오렌지
        Fruit apple = new Fruit("사과", 3000, false, false, 0);
        Fruit orange = new Fruit("오렌지", 5000, false, false, 0);
        Fruit banana = new Fruit("바나나", 7000, true, false, 0);
        Fruit grape = new Fruit("포도", 6000, false, true, 0);

        fruitHashMap.put("apple", apple);
        fruitHashMap.put("orange", orange);
        fruitHashMap.put("banana", banana);
        fruitHashMap.put("grape", grape);

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
        requestCount++;
        if (requestCount > 5) {
            sendResponse(out, "429 Too Many Requests", "text/html",
                    "<html><body><h1>과일 안내 업무가 종료되었습니다</h1></body></html>");
            return;
        }
        String line = null;
        StringBuilder requestBuilder = new StringBuilder();
        while ((line = in.readLine()) != null && !line.isEmpty()) {
            requestBuilder.append(line + "\n");
        }

        String request = requestBuilder.toString();
        System.out.println(request);

        if (request.startsWith("GET")) {
            String parsingFruitName = request.replaceAll("GET /", "").split(" ")[0];
            if (!fruitHashMap.containsKey(parsingFruitName)) {
                sendResponse(out, "404 Not Found", "text/html",
                        "<html><body><h1>농장에 없는 과일입니다.</h1></body></html>");
                return;
            }
            Fruit fruit = fruitHashMap.get(parsingFruitName);

            // bonus
            if (fruit.getRequestCount() >= 1) {
                sendResponse(out, "410 Gone", "text/html",
                        "<html><body><h1>이미 정보를 안내한 과일입니다.</h1></body></html>");
            }

            fruit.increaseRequestCount();

            if (fruit.isFarmChanged()) {
                sendResponse(out, "301 Moved Permanently", "text/html",
                        "<html><body><h1>다른 농장으로 이동하였습니다.</h1></body></html>");
                return;
            }

            if (fruit.isReserved()) {
                sendResponse(out, "403 Forbidden", "text/html",
                        "<html><body><h1>예약된 과일입니다.</h1></body></html>");
                return;
            }
            sendResponse(out, "200 OK", "text/html",
                    "<html><body><h1>" + fruit.getName() + " 가격은 " + fruit.getPrice() +
                            "이며, 곧 수확예정입니다.</h1></body></html>");

        } else {
            sendResponse(out, "405 Method Not Allowed", "text/html",
                    "<html><body><h1>현재는 농장의 과일 정보 조회만 가능합니다.</h1></body></html>");
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