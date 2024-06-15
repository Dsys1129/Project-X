package com.duobiodome06.controller;

import com.duobiodome06.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<?> signup(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO result = userService.signup(userRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestDTO userRequestDTO, HttpServletRequest request) {
        UserResponseDTO result = userService.login(userRequestDTO);
        HttpSession session = request.getSession();
        session.setAttribute("userId", userRequestDTO.getUserId());
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
