package com.vitabidome09;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

//TODO 일반, 보너스 완료
@WebServlet("/")
public class Main extends HttpServlet {
    Map<String, User> userMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        User admin = new User("biodomeAdmin", "biodomeAdmin", UserType.ADMIN);
        User user = new User("biodomeUser1", "biodomeUser1", UserType.USER);
        userMap.put("biodomeAdmin", admin);
        userMap.put("biodomeUser1", user);
        admin.getPasswordHistory().add(admin.getPassword());
        user.getPasswordHistory().add(user.getPassword());
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(request.getRequestURI());
        System.out.println(request.getServletPath());
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader == null || authorizationHeader.isBlank()) {
            sendResponse(response, HttpServletResponse.SC_BAD_REQUEST,
                    "{\"message\":\"Authorization Header가 존재하지 않습니다.\"}");
            return;
        }
        AuthenticationRequest authenticationRequest = parsingIdAndPassword(request);
        User user = userMap.get(authenticationRequest.getId());

        if (user == null) {
            sendResponse(response, HttpServletResponse.SC_NOT_FOUND,
                    "{\"message\":\"아이디가 존재하지 않습니다.\"}");
            return;
        }

        if (request.getServletPath().equals("/")) {
            if (user.getPassword().equals(PasswordUtil.decode(authenticationRequest.getPassword()))) {
                sendResponse(response, HttpServletResponse.SC_OK,
                        "{\"message\":\"[" + user.getId() + "]님, 스토리지에 오신걸 환영합니다!\"}");
                return;
            } else {
                sendResponse(response, HttpServletResponse.SC_UNAUTHORIZED,
                        "{\"message\":\"비밀번호가 일치하지 않습니다.\"}");
                return;
            }
        }

        if (request.getServletPath().equals("/admin")) {

            if (user.getUserType() != UserType.ADMIN) {
                sendResponse(response, HttpServletResponse.SC_FORBIDDEN,
                        "{\"message\":\"권한이 없습니다.\"}");
                return;
            }

            sendResponse(response, HttpServletResponse.SC_OK,
                    "{\"message\":\"매니저 [" + user.getId() + "]님, 관리페이지에 오신걸 환영합니다.\"}");
        }
        if (request.getServletPath().equals("/previous-password")) {
            if (user.getPasswordHistory().isEmpty()) {
                sendResponse(response, HttpServletResponse.SC_OK,
                        "{\"message\":\"패스워드 변경 이력이 없습니다.\"}");
                return;
            }

            sendResponse(response, HttpServletResponse.SC_OK,
                    "{\"message\":\"이전 패스워드는 " + user.getLastChangedPassword() + "입니다.\"}");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getServletPath().equals("/change-password")) {
            String id = parsingId(request);
            User user = userMap.get(id);

            if (user == null) {
                sendResponse(response, HttpServletResponse.SC_NOT_FOUND,
                        "{\"message\":\"아이디가 존재하지 않습니다.\"}");
                return;
            }

            String requestBodyJson = request.getReader().lines().collect(Collectors.joining()).trim();
            String newPassword = parsePassword(requestBodyJson, "newPassword");
            if (newPassword.isBlank()) {
                sendResponse(response, HttpServletResponse.SC_BAD_REQUEST,
                        "{\"message\":\"변경할 패스워드를 입력해주세요\"}");
                return;
            }
            user.changePassword(newPassword);
            sendResponse(response, HttpServletResponse.SC_OK,
                    "{\"message\":\"비밀번호를 성공적으로 변경했습니다.\"}");
        }
    }

    private AuthenticationRequest parsingIdAndPassword(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        String[] authorizationSplit = authorization.split(":");

        String id = authorizationSplit[0];
        String encodedPassword = authorizationSplit[1];
        return new AuthenticationRequest(id, encodedPassword);
    }

    private String parsingId(HttpServletRequest request) {
        return request.getHeader("Authorization").split(":")[0];
    }

    private String parsePassword(String json, String key) {
        String searchKey = "\"" + key + "\":";
        int startIndex = json.indexOf(searchKey) + searchKey.length();

        // 제거되지 않은 공백 제거
        while (json.charAt(startIndex) == ' ') {
            startIndex++;
        }

        char startChar = json.charAt(startIndex);

        // 문자열 값인지 숫자 값인지 확인
        if (startChar == '\"') {
            // 문자열 값인 경우
            int endIndex = json.indexOf("\"", startIndex + 1);
            return json.substring(startIndex + 1, endIndex);
        } else {
            // 숫자 값인 경우
            int endIndex = json.indexOf(",", startIndex);
            if (endIndex == -1) {
                endIndex = json.indexOf("}", startIndex);
            }
            return json.substring(startIndex, endIndex).trim();
        }
    }

    private void sendResponse(HttpServletResponse response, int statusCode, String content) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(statusCode);
        response.getWriter().write(content);
    }
}