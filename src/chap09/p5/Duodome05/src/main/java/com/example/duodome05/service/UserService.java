package com.example.duodome05.service;


import com.example.duodome05.controller.UserRequestDTO;
import com.example.duodome05.controller.UserResponseDTO;
import com.example.duodome05.global.exception.custom.AuthenticationFailException;
import com.example.duodome05.global.exception.custom.UserNotFoundException;
import com.example.duodome05.repository.UserRepository;
import com.example.duodome05.user.PasswordEncoder;
import com.example.duodome05.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO signup(UserRequestDTO userRequestDTO) {
        String encryptedPassword = PasswordEncoder.encrypt(userRequestDTO.getUserId(), userRequestDTO.getPassword());
        userRequestDTO.setPassword(encryptedPassword);
        User user = userRequestDTO.toEntity();
        userRepository.save(user);
        return new UserResponseDTO(user.getUserId());
    }

    public UserResponseDTO login(UserRequestDTO userRequestDTO) {
        User user = userRepository.findById(userRequestDTO.getUserId());
        if (user == null) {
            throw new UserNotFoundException("존재하지 않는 유저입니다.");
        }

        String encryptedPassword = PasswordEncoder.encrypt(user.getUserId(), userRequestDTO.getPassword());

        if (!user.getPassword().equals(encryptedPassword)) {
            throw new AuthenticationFailException("로그인에 실패하였습니다.");
        }
        return new UserResponseDTO(user.getUserId());
    }
}
