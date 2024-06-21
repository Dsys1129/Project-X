package com.duodome08.user.service;


import com.duodome08.global.exception.custom.AuthenticationFailException;
import com.duodome08.global.exception.custom.UserNotFoundException;
import com.duodome08.user.PasswordEncoder;
import com.duodome08.user.User;
import com.duodome08.user.controller.UserRequestDTO;
import com.duodome08.user.controller.UserResponseDTO;
import com.duodome08.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final Logger log = LoggerFactory.getLogger(getClass());


    public UserResponseDTO signup(UserRequestDTO userRequestDTO) {
        String encryptedPassword = PasswordEncoder.encrypt(userRequestDTO.getUserId(), userRequestDTO.getPassword());
        userRequestDTO.setPassword(encryptedPassword);
        User user = userRequestDTO.toEntity();
        userRepository.save(user);
        log.info("[회원 가입] userId: {}", user.getUserId());
        return new UserResponseDTO(user.getUserId());
    }

    public UserResponseDTO login(UserRequestDTO userRequestDTO, HttpServletRequest request) {
        User user = userRepository.findById(userRequestDTO.getUserId());
        if (user == null) {
            throw new UserNotFoundException("존재하지 않는 유저입니다.");
        }

        String encryptedPassword = PasswordEncoder.encrypt(user.getUserId(), userRequestDTO.getPassword());

        if (!user.getPassword().equals(encryptedPassword)) {
            throw new AuthenticationFailException("로그인에 실패하였습니다.");
        }
        request.getSession().setAttribute("user", user);
        log.info("[로그인] userId: {}", user.getUserId());
        return new UserResponseDTO(user.getUserId());
    }
}
