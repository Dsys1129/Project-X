package com.duobiodome06.service;


import com.duobiodome06.controller.UserRequestDTO;
import com.duobiodome06.controller.UserResponseDTO;
import com.duobiodome06.global.exception.custom.AuthenticationFailException;
import com.duobiodome06.global.exception.custom.UserNotFoundException;
import com.duobiodome06.repository.UserRepository;
import com.duobiodome06.user.PasswordEncoder;
import com.duobiodome06.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private  UserRepository userRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDTO signup(UserRequestDTO userRequestDTO) {
        String encryptedPassword = PasswordEncoder.encrypt(userRequestDTO.getUserId(), userRequestDTO.getPassword());
        userRequestDTO.setPassword(encryptedPassword);
        User user = userRequestDTO.toEntity();
        userRepository.save(user);
        log.info("[회원 가입] userId: {}", user.getUserId());
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
        log.info("[로그인] userId: {}", user.getUserId());
        return new UserResponseDTO(user.getUserId());
    }
}
