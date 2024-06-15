package com.duobiodome06.global.filter;

import com.duobiodome06.global.exception.custom.AuthenticationFailException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthenticationFilter extends OncePerRequestFilter {

    private Logger log = LoggerFactory.getLogger(SLF4JLogger.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("[Request] {}", request.getServletPath());

        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession(false);
        if (!requestURI.startsWith("/login") && !requestURI.startsWith("/users")) {
            if (session == null || session.getAttribute("userId") == null) {
                throw new AuthenticationFailException("인증에 실패하였습니다.");
            }
        }
        filterChain.doFilter(request, response);
    }
}
