package com.example.duodome04.service;


import com.example.duodome04.controller.UserRequestDTO;
import com.example.duodome04.exception.custom.InvalidEmailFormatException;
import com.example.duodome04.exception.custom.UserNotFoundException;
import com.example.duodome04.repository.UserRepository;
import com.example.duodome04.user.PasswordEncoder;
import com.example.duodome04.user.User;
import com.example.duodome04.controller.UserResponseDTO;
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
            throw new UserNotFoundException("존재하지 않는 사용자입니다.");
        }

        return new UserResponseDTO(findUser.getUserId(), findUser.getName());
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        if (!EmailValidator.isValidEmail(userRequestDTO.getEmail())) {
            throw new InvalidEmailFormatException("이메일 형식이 올바르지 않습니다.");
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
