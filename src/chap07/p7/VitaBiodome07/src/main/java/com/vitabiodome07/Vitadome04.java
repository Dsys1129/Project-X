package com.vitabiodome07;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

//TODO 기본, 보너스 완료
// 추후 테스트
// 리팩토링 필요
@WebServlet("/")
public class Vitadome04 extends HttpServlet {
    private Map<String, Visitor> visitorMap = new HashMap<>();
    private Map<String, Integer> refererCountMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        Visitor testVisitor = new Visitor("47.121.85.71");
        testVisitor.increaseVisitCount();
        testVisitor.increaseVisitCount();
        testVisitor.increaseVisitCount();
        testVisitor.increaseVisitCount();
        visitorMap.put("47.121.85.71", testVisitor);
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestURI = request.getServletPath();

        if (!requestURI.equals("/top-referer") && !requestURI.equals("/visit")) {
            sendResponse(response, HttpServletResponse.SC_NOT_FOUND, "{\"message\": \"잘못된 경로입니다.\"}" );
            return;
        }

        if (requestURI.equals("/top-referer")) {
            Optional<String> maxReferer = refererCountMap.entrySet().stream().
                    max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey);
            if (maxReferer.isPresent()) {
                sendResponse(response, HttpServletResponse.SC_OK,
                        "{\"message\": \"가장 많이 방문한 referer는 " + maxReferer.get() + " 입니다.\"}");
                return;
            }
            sendResponse(response, HttpServletResponse.SC_OK,
                    "{\"message\": \"방문한 referer가 없습니다.\"}");
            return;
        }

        String clientIp = request.getHeader("X-Forwarded-For");

        if (clientIp == null || clientIp.isBlank()) {
            sendResponse(response, HttpServletResponse.SC_BAD_REQUEST,
                    "{\"message\": \"잘못된 요청입니다.\"}" );
            return;
        }

        Visitor visitor = visitorMap.get(clientIp);
        if (visitor == null) {
            sendResponse(response, HttpServletResponse.SC_OK,
                    "{\"message\": \"방문 기록이 없습니다.\"}");
        } else {
            sendResponse(response, HttpServletResponse.SC_OK,
                    "{\"message\": \"방문 횟수: " + visitor.getVisitCount() + "\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestURI = request.getServletPath();
        System.out.println(requestURI);
        if (!requestURI.equals("/visit")) {
            sendResponse(response, HttpServletResponse.SC_NOT_FOUND,
                    "{\"message\": \"잘못된 경로입니다.\"}" );
            return;
        }

        String clientIp = request.getHeader("X-Forwarded-For");

        if (clientIp == null || clientIp.isBlank()) {
            sendResponse(response, HttpServletResponse.SC_BAD_REQUEST,
                    "{\"message\": \"잘못된 요청입니다.\"}" );
            return;
        }


        Visitor visitor = visitorMap.get(clientIp);
        String referer = request.getHeader("referer");
        Integer refererCount = refererCountMap.get(referer);

        if (visitor == null) {
            visitor = new Visitor(clientIp);
            visitorMap.put(clientIp, visitor);
            visitor.increaseVisitCount();
            if (refererCount != null) {
                refererCountMap.put(referer, refererCountMap.getOrDefault(referer, 0) + 1);
            }
        }

        if (visitor.isValidVisit()) {
            visitor.increaseVisitCount();
            if (refererCount != null) {
                refererCountMap.put(referer, refererCountMap.getOrDefault(referer, 0) + 1);
            }
        }

        if (visitor.getVisitCount() > 0 && visitor.getVisitCount() % 5 == 0) {
            int luckyNumber = new Random().nextInt(101);
            sendResponse(response, HttpServletResponse.SC_OK,
                    "{\"message\": \"환영합니다, 당신의 행운번호는 " + luckyNumber + "입니다.\"}");
            return;
        }
        if (referer != null) {
            sendResponse(response, HttpServletResponse.SC_OK,
                    "{\"message\": \"멀리 " + referer + "에서 찾아오셨군요, 환영합니다.\"}");
            return;
        }

        sendResponse(response, HttpServletResponse.SC_OK,
                "{\"message\": \"방문 횟수: " + visitor.getVisitCount() + "\"}");
    }


    private void sendResponse(HttpServletResponse response, int statusCode, String content) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(statusCode);
        response.getWriter().write(content);
    }
}