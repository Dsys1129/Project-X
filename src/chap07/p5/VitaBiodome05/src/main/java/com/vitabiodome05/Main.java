package com.vitabiodome05;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

@WebServlet(value = "/")
public class Main extends HttpServlet {
    private static HashMap<String, Fruit> fruitHashMap = new HashMap<>();
    private int requestCount;


    public void init() {
        Fruit apple = new Fruit("사과", 3000, false, false, 0);
        Fruit orange = new Fruit("오렌지", 5000, false, false, 0);
        Fruit banana = new Fruit("바나나", 7000, true, false, 0);
        Fruit grape = new Fruit("포도", 6000, false, true, 0);

        fruitHashMap.put("apple", apple);
        fruitHashMap.put("orange", orange);
        fruitHashMap.put("banana", banana);
        fruitHashMap.put("grape", grape);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        requestCount++;

        String requestURI = request.getRequestURI();
        String fruitName = requestURI.substring(1);

        if (requestURI.equals("/now")) {
            LocalDateTime now = LocalDateTime.now();
            String formattedDate = now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            sendResponse(response, HttpServletResponse.SC_OK, "{\"serverTime\": \"" + formattedDate + "\"}");
            return;
        }

        if (requestCount > 5) {
            sendResponse(response, 429,
                    "{\"message\": \"과일 안내 업무가 종료되었습니다\"}");
            return;
        }

        if (!fruitHashMap.containsKey(fruitName)) {
            sendResponse(response, HttpServletResponse.SC_NOT_FOUND,
                    "{\"message\": \"농장에 없는 과일입니다\"}");
            return;
        }

        Fruit fruit = fruitHashMap.get(fruitName);

        if (fruit.isFarmChanged()) {
            sendResponse(response, HttpServletResponse.SC_MOVED_PERMANENTLY,
                    "{\"message\": \"다른 농장으로 이동하였습니다\"}");
            return;
        }

        if (fruit.isReserved()) {
            sendResponse(response, HttpServletResponse.SC_FORBIDDEN,
                    "{\"message\": \"예약된 과일입니다\"}");
            return;
        }

        sendResponse(response, HttpServletResponse.SC_OK,
                "{\"message\": \"" + fruit.getName() + "의 가격은 " + fruit.getPrice() + "원 입니다\"}");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestURI = request.getRequestURI();

        if (requestURI.equals("/reset")) {
            requestCount = 0;
            sendResponse(response, HttpServletResponse.SC_OK,
                    "{\"message\": \"Request counts have been reset.\"}");
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
}