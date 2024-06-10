package com.joinbiodome04;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.joinbiodome04.user.Interest;
import com.joinbiodome04.user.Team;
import com.joinbiodome04.user.User;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "userServlet", value = "/users/*")
public class HelloServlet extends HttpServlet {

    private UserRepository userRepository = new UserRepository();
    private Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer()).create();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo.equals("/interests/popular")) {
            List<Interest> popularInterest = userRepository.findPopularInterest();
            String json = gson.toJson(popularInterest);
            sendResponse(response, HttpServletResponse.SC_OK, json);
            return;
        }

        if (pathInfo.equals("/teams/least-active")) {
            List<Team> leastActiveTeam = userRepository.findLeastActiveTeam();
            String json = gson.toJson(leastActiveTeam);
            sendResponse(response, HttpServletResponse.SC_OK, json);
            return;
        }

        if (pathInfo.equals("/recent")) {
            User recentCreatedUser = userRepository.findRecentCreatedUser();
            String json = gson.toJson(recentCreatedUser);
            sendResponse(response, HttpServletResponse.SC_OK, json);
            return;
        }

        sendResponse(response, HttpServletResponse.SC_NOT_FOUND, "\"message\":\"페이지를 찾을 수 없습니다\"");
    }

    private void sendResponse(HttpServletResponse response, int statusCode, String content) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(statusCode);
        response.getWriter().write(content);
    }
}