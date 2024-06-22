package com.duodome11.user.controller;

import com.duodome11.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> signup(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO result = userService.signup(userRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestDTO userRequestDTO, HttpServletRequest request) {
        UserResponseDTO result = userService.login(userRequestDTO, request);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
        return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("message", "로그아웃 되었습니다."));
    }
}
