package com.example.duodome03.service;

import com.example.duodome03.user.PasswordEncoder;
import com.example.duodome03.user.User;
import com.example.duodome03.user.UserResponseDTO;
import com.example.duodome03.controller.UserRequestDTO;
import com.example.duodome03.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO findUser(String userId) {
        User findUser = userRepository.findById(userId);

        if (findUser == null) {
            throw new IllegalArgumentException("해당하는 유저가 없습니다.");
        }

        return new UserResponseDTO(findUser.getUserId(), findUser.getName());
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        if (!EmailValidator.isValidEmail(userRequestDTO.getEmail())) {
            throw new IllegalArgumentException("올바른 이메일 형식이 아닙니다.");
        }

        String encryptedPassword = PasswordEncoder.encrypt(userRequestDTO.getUserId(), userRequestDTO.getPassword());
        userRequestDTO.setPassword(encryptedPassword);
        User user = userRequestDTO.toEntity();
        userRepository.save(user);
        return new UserResponseDTO(user.getUserId(), user.getName());
    }

    public UserResponseDTO updatePassword(String userId, String password) {
        User user = userRepository.findById(userId);
        String encryptedPassword = PasswordEncoder.encrypt(userId, password);
        user.updatePassword(encryptedPassword);
        userRepository.updatePassword(user);
        return new UserResponseDTO(user.getUserId(), user.getName());
    }

    public UserResponseDTO deleteUser(String userId) {
        User user = userRepository.findById(userId);
        userRepository.deleteUser(user);
        return new UserResponseDTO(user.getUserId(), user.getName());
    }
}
