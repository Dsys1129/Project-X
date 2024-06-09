package com.vitabiodome08;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//TODO 기본, 보너스 완료
@WebServlet(name = "main", value = "/")
public class Main extends HttpServlet {
    private String message;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getServletPath();
        if (path.equals("/naver")) {
            handleBonusRequest(request, response);
            return;
        }
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        handleRequest(request, response);
    }

    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String userAgent = request.getHeader("User-Agent");
        String redirectUrl = determineRedirectURL(userAgent);

        response.setStatus(getRedirectStatusCode(userAgent));
        response.setHeader("Location", redirectUrl);
    }

    private String determineRedirectURL(String userAgent) {
        if (userAgent.contains("Windows")) {
            return "https://www.nasa.gov";
        } else if (userAgent.contains("Mac OS")) {
            return "https://www.nps.gov/yose/index.html";
        } else if (userAgent.contains("Linux")) {
            return "https://www.greenpeace.org/korea";
        } else if (userAgent.contains("Android") || userAgent.contains("IPhone")) {
            return "https://www.wwfkorea.or.kr";
        } else {
            return "https://www.natgeokorea.com";
        }
    }

    private int getRedirectStatusCode(String userAgent) {
        if (userAgent.contains("Windows")) {
            return HttpServletResponse.SC_MOVED_PERMANENTLY; // 301
        } else if (userAgent.contains("Mac OS")) {
            return HttpServletResponse.SC_FOUND; // 302
        } else if (userAgent.contains("Linux")) {
            return HttpServletResponse.SC_SEE_OTHER; // 303
        } else if (userAgent.contains("Android") || userAgent.contains("IPhone")) {
            return HttpServletResponse.SC_TEMPORARY_REDIRECT; // 307
        } else {
            return HttpServletResponse.SC_MULTIPLE_CHOICES; // 300
        }
    }

    private void handleBonusRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String referer = request.getHeader("Referer");

        if (referer != null && referer.contains("biodome-citizen.com")) {
            String userAgent = request.getHeader("User-Agent");
            String redirectUrl;

            if (userAgent.contains("Android") || userAgent.contains("iPhone")) {
                redirectUrl = "https://m.naver.com";
            } else {
                redirectUrl = "https://naver.com";
            }

            response.setStatus(HttpServletResponse.SC_FOUND);
            response.setHeader("Location", redirectUrl);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "리다이렉트 거부");
        }
    }
}