package com.example.duodome04.controller;

import com.example.duodome04.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> findUser(@PathVariable String userId) {
        UserResponseDTO result = userService.findUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping()
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO result = userService.createUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<?> createUser(@PathVariable String userId, @RequestBody Map<String, String> password) {
        UserResponseDTO result = userService.updatePassword(userId, password.get("password"));
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> createUser(@PathVariable String userId) {
        UserResponseDTO result = userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
