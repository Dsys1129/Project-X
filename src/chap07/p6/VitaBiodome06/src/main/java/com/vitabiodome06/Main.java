package com.vitabiodome06;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//TODO 기본, 보너스 완료
@WebServlet("/")
public class Main extends HttpServlet {
    private static HashMap<String, Fruit> fruitHashMap = new HashMap<>();
    private static String lastRequestFruit = null;

    public void init() {
        Fruit apple = new Fruit("사과", 3000, 25);
        Fruit orange = new Fruit("오렌지", 5000, 19);
        Fruit melon = new Fruit("멜론", 17000, 19);
        Fruit grape = new Fruit("포도", 6000, 0);

        fruitHashMap.put("apple", apple);
        fruitHashMap.put("orange", orange);
        fruitHashMap.put("melon", melon);
        fruitHashMap.put("grape", grape);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String requestURI = request.getRequestURI();

        if (requestURI.equals("/recent-requested")) {
            // 최근 조회된 과일 이름을 반환
            sendResponse(response, HttpServletResponse.SC_OK,
                    "{\"recentRequestedFruit\": \"" + lastRequestFruit + "\"}");
            return;
        }
        String fruitName = requestURI.substring(1);
        lastRequestFruit = fruitName;

        if (requestURI.equals("/")) {
            String fruitList = fruitHashMap.keySet().stream().collect(Collectors.joining(", "));
            sendResponse(response, HttpServletResponse.SC_OK,
                    "{\"message\": \"농장에서 보유한 과일: " + fruitList + "\"}");
            return;
        }

        if (!fruitHashMap.containsKey(fruitName)) {
            sendResponse(response, HttpServletResponse.SC_NOT_FOUND, "{\"message\": \"농장에 없는 과일입니다\"}");
            return;
        }

        Fruit fruit = fruitHashMap.get(fruitName);
        sendResponse(response, HttpServletResponse.SC_OK,
                "{\"message\": \"" + fruit.getName() + "의 가격은 "
                        + fruit.getPrice() + "원, 재고는 " + fruit.getStock() + "개 입니다\"}");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line.trim());
        }
        Map<String, String> requestParams = parseRequestParams(sb.toString());

        String name = requestParams.get("name");
        String priceStr = requestParams.get("price");

        if (name == null || priceStr == null) {
            sendResponse(response, HttpServletResponse.SC_BAD_REQUEST,
                    "{\"message\": \"이름과 가격을 입력해 주세요\"}");
            return;
        }

        if (fruitHashMap.containsKey(name.toLowerCase())) {
            sendResponse(response, HttpServletResponse.SC_CONFLICT, "{\"message\": \"이미 등록된 과일입니다\"}");
            return;
        }

        int price = Integer.parseInt(priceStr);

        Fruit newFruit = new Fruit(name, price, 1);
        fruitHashMap.put(name.toLowerCase(), newFruit);

        sendResponse(response, HttpServletResponse.SC_CREATED,
                "{\"message\": \"" + name + "이(가) 추가되었습니다\"}");
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestURI = request.getRequestURI();
        String fruitName = requestURI.substring(1);

        if (!fruitHashMap.containsKey(fruitName)) {
            sendResponse(response, HttpServletResponse.SC_NOT_FOUND, "{\"message\": \"농장에 없는 과일입니다\"}");
            return;
        }

        Fruit fruit = fruitHashMap.get(fruitName);
        fruit.addStock(1);

        sendResponse(response, HttpServletResponse.SC_OK,
                "{\"message\": \"" + fruit.getName() + "의 재고가 1개 추가되어 현재 재고는 "
                        + fruit.getStock() + "개 입니다\"}");
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestURI = request.getRequestURI();
        String fruitName = requestURI.substring(1);

        if (!fruitHashMap.containsKey(fruitName)) {
            sendResponse(response, HttpServletResponse.SC_NOT_FOUND,
                    "{\"message\": \"농장에 없는 과일입니다\"}");
            return;
        }

        fruitHashMap.remove(fruitName);
        sendResponse(response, HttpServletResponse.SC_NO_CONTENT,
                "{\"message\": \"" + fruitName + "이(가) 삭제되었습니다\"}");
    }

    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/")) {
            String content = "{\"GET\": \"과일 정보 조회\", \"POST\": \"새로운 과일 추가\", \"PUT\": \"과일 재고 추가\"," +
                    " \"DELETE\": \"과일 삭제\", \"OPTIONS\": \"서버가 지원하는 HTTP 메서드 조회\"}";
            sendResponse(response, HttpServletResponse.SC_OK, content);
        }
    }

    public void destroy() {
    }

    private void sendResponse(HttpServletResponse response, int statusCode, String content) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(statusCode);
        response.getWriter().write(content);
    }

    private static String parseValue(String json, String key) {
        String searchKey = "\"" + key + "\":";
        int startIndex = json.indexOf(searchKey) + searchKey.length();

        // 제거되지 않은 공백 제거
        while (json.charAt(startIndex) == ' ') {
            startIndex++;
        }

        char startChar = json.charAt(startIndex);

        // 문자열 값인지 숫자 값인지 확인
        if (startChar == '\"') {
            // 문자열 값인 경우
            int endIndex = json.indexOf("\"", startIndex + 1);
            return json.substring(startIndex + 1, endIndex);
        } else {
            // 숫자 값인 경우
            int endIndex = json.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = json.indexOf("}", startIndex);
            }
            return json.substring(startIndex, endIndex).trim();
        }
    }

    private Map<String, String> parseRequestParams(String body) {
        Map<String, String> params = new HashMap<>();
        String name = parseValue(body, "name");
        String price = parseValue(body, "price");
        params.put("name", name);
        params.put("price", price);
        return params;
    }
}