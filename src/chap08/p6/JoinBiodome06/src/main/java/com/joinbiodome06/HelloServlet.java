package com.joinbiodome06;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//TODO 기본, 보너스 문제 완료
@WebServlet(name = "helloServlet", value = "/")
public class HelloServlet extends HttpServlet {

    private MemoryManager memoryManager = new MemoryManager();
    private Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer()).create();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getServletPath();
        String json = null;
        try {
            switch (pathInfo) {
                case "/memory-usage":
                    Map<String, Double> memoryUsage = memoryManager.getMemoryUsage();
                    json = gson.toJson(memoryUsage);
                    sendResponse(response, HttpServletResponse.SC_OK, json);
                    break;
                case "/available-processors":
                    int availableProcessors = memoryManager.getAvailableProcessors();
                    json = gson.toJson(Map.of("availableProcessor", availableProcessors));
                    sendResponse(response, HttpServletResponse.SC_OK, json);
                    break;
                case "/gc-count":
                    long gcCount = memoryManager.getGcCount();
                    json = gson.toJson(Map.of("gc-count", gcCount));
                    sendResponse(response, HttpServletResponse.SC_OK, json);
                    break;
                case "/memory-trends":
                    List<MemoryHistory> memoryHistoryList = memoryManager.getMemoryHistoryList();
                    json = gson.toJson(memoryHistoryList);
                    sendResponse(response, HttpServletResponse.SC_OK, json);
                    break;
                default:
                    sendResponse(response, HttpServletResponse.SC_NOT_FOUND, "{\"message\":\"잘못된 경로입니다\"}");
            }
        } catch (Exception e) {
            sendResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "{\"message\":\"" + e.getMessage() + "\"}");
        }
    }

    private void sendResponse(HttpServletResponse response, int statusCode, String content) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(statusCode);
        response.getWriter().write(content);
    }
}