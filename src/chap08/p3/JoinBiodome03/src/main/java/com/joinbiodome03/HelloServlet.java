package com.joinbiodome03;

import com.joinbiodome03.user.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//TODO 기본 문제 완료
@WebServlet(name = "userServlet", value = "/users/*")
public class HelloServlet extends HttpServlet {

    private UserRepository userRepository = new UserRepository();

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            long userId = Long.parseLong(request.getPathInfo().substring(1));
            User findUser = userRepository.findUserById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("해당하는 유저가 없습니다."));
            userRepository.delete(findUser);
            sendResponse(response, HttpServletResponse.SC_OK, "\"message\":\"정상적으로 유저가 삭제되었습니다.\"");
        } catch (NumberFormatException e) {
            sendResponse(response, HttpServletResponse.SC_NOT_FOUND, "\"message\":\"잘못된 입력입니다.\"");
        } catch (NullPointerException e) {
            sendResponse(response, HttpServletResponse.SC_NOT_FOUND, "\"message\":\"존재하지 않는 사용자입니다.\"");

        }
    }

    private void sendResponse(HttpServletResponse response, int statusCode, String content) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(statusCode);
        response.getWriter().write(content);
    }
}