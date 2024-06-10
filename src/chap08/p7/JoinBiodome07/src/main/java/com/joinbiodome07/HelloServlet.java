package com.joinbiodome07;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//TODO 기본 문제 완료
@WebServlet(name = "helloServlet", value = "/")
public class HelloServlet extends HttpServlet {

    private PostManager postManager = new PostManager();
    private Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer()).create();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/posts":
                List<String> allPostTitleOrderByTitleASC = postManager.findAllPostTitleOrderByCreatedAtASC();
                if (allPostTitleOrderByTitleASC.isEmpty()) {
                    sendResponse(response, HttpServletResponse.SC_NOT_FOUND, "{\"message\":\"포스트가 없습니다.\"}");
                    return;
                }

                String json = gson.toJson(allPostTitleOrderByTitleASC);
                sendResponse(response, HttpServletResponse.SC_OK, json);
                break;
            default:
                sendResponse(response, HttpServletResponse.SC_NOT_FOUND, "{\"message\":\"잘못된 경로입니다\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/posts":
                try {
                    PostRequest postRequest = gson.fromJson(request.getReader(), PostRequest.class);
                    Post post = postRequest.toEntity();
                    postManager.writePost(post);
                    String json = gson.toJson(post);
                    sendResponse(response, HttpServletResponse.SC_OK, json);
                } catch (IllegalArgumentException e) {
                    sendResponse(response, HttpServletResponse.SC_BAD_REQUEST, gson.toJson(Map.of("mesage", e)));
                }
                break;
            default:
                sendResponse(response, HttpServletResponse.SC_NOT_FOUND, gson.toJson(Map.of("message", "잘못된 경로입니다.")));
        }
    }

    private void sendResponse(HttpServletResponse response, int statusCode, String content) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(statusCode);
        response.getWriter().write(content);
    }
}