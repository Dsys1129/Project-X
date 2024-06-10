package com.joinbiodome01.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.joinbiodome01.LocalDateTimeSerializer;
import com.joinbiodome01.UserRepository;
import com.joinbiodome01.UserRequest;
import com.joinbiodome01.exception.DuplicatedUserException;
import com.joinbiodome01.user.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

//TODO 기본, 보너스 완료
@WebServlet(name = "userServlet", value = "/users")
public class UserServlet extends HttpServlet {

    private Gson gson = new GsonBuilder()
            .serializeNulls()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer()).create();
    private UserRepository userRepository = new UserRepository();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String queryString = request.getQueryString();

        if (queryString != null &&
                (!queryString.startsWith("interest") && !queryString.startsWith("team"))) {
            String errorMessage = "{\"message\": \"잘못된 쿼리 파라미터 입니다.\"}";
            sendResponse(response, HttpServletResponse.SC_NOT_FOUND, errorMessage);
            return;
        }

        List<User> users = null;
        String json = null;

        if (queryString == null) {
            users = userRepository.findAll();
            json = gson.toJson(users);
        }

        if (queryString != null && queryString.startsWith("interest")) {
            String interest = request.getParameter("interest");
            users = userRepository.findUserByInterest(interest);
            json = gson.toJson(users);
        }

        if (queryString != null && queryString.startsWith("team")) {
            String team = request.getParameter("team");
            users = userRepository.findUserByTeam(team);
            json = gson.toJson(users);
        }

        if (users.isEmpty()) {
            json = "{\"message\": \"조건에 맞는 사용자가 없습니다.\"}";
        }

        sendResponse(response, HttpServletResponse.SC_OK, json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        try {
            UserRequest userRequest = gson.fromJson(reader, UserRequest.class);
            User user = userRequest.toUser();
            userRepository.save(user);
            sendResponse(response, HttpServletResponse.SC_CREATED,
                    "{\"message\": \"" + user.getName() + "님 커뮤니티 가입이 완료되었습니다.\"}");
        } catch (DuplicatedUserException e) {
            sendResponse(response, HttpServletResponse.SC_CONFLICT,
                    "{\"message\": \""+ e.getMessage() + "\"}");
        } catch (IllegalArgumentException e) {
            sendResponse(response, HttpServletResponse.SC_BAD_REQUEST,
                    "{\"message\": \""+ e.getMessage() + "\"}");
        }
    }

    private void sendResponse(HttpServletResponse response, int statusCode, String content) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(statusCode);
        response.getWriter().write(content);
    }
}