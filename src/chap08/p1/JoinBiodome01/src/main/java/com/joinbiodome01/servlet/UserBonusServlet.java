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

@WebServlet(name = "userBonusServlet", value = "/users/*")
public class UserBonusServlet extends HttpServlet {

    private UserRepository userRepository = new UserRepository();
    private Gson gson = new GsonBuilder().
            serializeNulls().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer()).create();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pathVariable = request.getPathInfo();

        Long userId = Long.parseLong(pathVariable.substring(1));

        User findUser = userRepository.findUserById(userId);

        if (findUser == null) {
            sendResponse(response, HttpServletResponse.SC_OK,
                    "{\"message\": \"조건에 맞는 사용자가 없습니다.\"}");
            return;
        }

        String result = gson.toJson(findUser);
        sendResponse(response, HttpServletResponse.SC_OK, result);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        try {
            UserRequest userRequest = gson.fromJson(reader, UserRequest.class);
            User user = userRequest.toUser();
            userRepository.saveWithId(user);
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
