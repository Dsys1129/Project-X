package com.joinbiodome02;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.joinbiodome02.user.User;
import com.joinbiodome02.user.UserRequestValidator;
import com.joinbiodome02.user.UserUpdateHistory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//TODO 기본, 보너스 완료

@WebServlet(name = "UserServlet", value = "/users/*")
public class UserServlet extends HttpServlet {

    private Gson gson = new GsonBuilder().serializeNulls().registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer()).create();
    private UserRepository userRepository = new UserRepository();
    private UserUpdateHistoryRepository userUpdateHistoryRepository = new UserUpdateHistoryRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo.equals("/edit-history")) {
            List<UserUpdateHistory> allUserUpdateHistory = userUpdateHistoryRepository.findAllUserUpdateHistory();
            if (allUserUpdateHistory.isEmpty()) {
                String message = "{\"message\": \"수정 이력이 없습니다.\"}";
                sendResponse(response, HttpServletResponse.SC_NOT_FOUND, message);
                return;
            }
            String json = gson.toJson(allUserUpdateHistory);
            sendResponse(response, HttpServletResponse.SC_OK, json);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long userId = null;
        UserRequest userRequest = null;
        try {
            userId = Long.parseLong(request.getPathInfo().substring(1));
            BufferedReader body = request.getReader();
            userRequest = gson.fromJson(body, UserRequest.class);
            UserRequestValidator.validateUserRequest(userRequest);
        } catch (NumberFormatException e) {
            sendResponse(response, HttpServletResponse.SC_BAD_REQUEST, "{\"message\": \"" + e.getMessage() + "\"}");
            return;
        } catch (IllegalArgumentException e) {
            sendResponse(response, HttpServletResponse.SC_BAD_REQUEST, "{\"message\": \"" + e.getMessage() + "\"}");
            return;
        }

        User findUser = userRepository.findUserById(userId);

        if (findUser == null) {
            String errorMessage = "{\"message\": \"해당하는 유저가 없습니다.\"}";
            sendResponse(response, HttpServletResponse.SC_NOT_FOUND, errorMessage);
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        UserUpdateHistory userUpdateHistory = new UserUpdateHistory(findUser, userRequest, now);
        findUser.update(userRequest);
        userRepository.update(findUser, now);
        userUpdateHistoryRepository.save(userUpdateHistory);

        User updatedUser = userRepository.findUserById(userId);
        String json = gson.toJson(updatedUser);
        sendResponse(response, HttpServletResponse.SC_OK, json);
    }

    private void sendResponse(HttpServletResponse response, int statusCode, String content) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(statusCode);
        response.getWriter().write(content);
    }
}