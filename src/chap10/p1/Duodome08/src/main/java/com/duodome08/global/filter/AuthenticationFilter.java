package com.duodome08.global.filter;

import com.duodome08.global.exception.custom.AuthenticationFailException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthenticationFilter extends OncePerRequestFilter {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("[Request] {}", request.getServletPath());

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            throw new AuthenticationFailException("인증에 실패하였습니다.");
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String requestURI = request.getRequestURI();
        return requestURI.startsWith("/login") || requestURI.startsWith("/users")
                || (request.getMethod().equals("GET") && requestURI.startsWith("/exploration-logs"));
    }
}
