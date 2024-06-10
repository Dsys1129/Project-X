package com.joinbiodome05;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// TODO 기본 문제 완료
@WebServlet(name = "UserServlet", value = "/valid-email")
public class HelloServlet extends HttpServlet {

    private Validator validator = new Validator();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");

        if (email == null || !validator.isValidEmail(email)) {
            sendResponse(response, HttpServletResponse.SC_BAD_REQUEST, "{\"message\":\"유효하지 않은 이메일입니다.\"}");
            return;
        }
        sendResponse(response, HttpServletResponse.SC_OK, "{\"message\":\"유효한 이메일입니다.\"}");
    }

    private void sendResponse(HttpServletResponse response, int statusCode, String content) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(statusCode);
        response.getWriter().write(content);
    }
}