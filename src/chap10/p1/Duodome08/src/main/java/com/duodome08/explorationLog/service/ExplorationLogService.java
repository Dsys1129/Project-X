package com.duodome08.explorationLog.service;

import com.duodome08.explorationLog.ExplorationLog;
import com.duodome08.explorationLog.controller.ExplorationLogRequestDTO;
import com.duodome08.explorationLog.controller.ExplorationLogResponseDTO;
import com.duodome08.explorationLog.controller.ExplorationLogUpdateRequestDTO;
import com.duodome08.explorationLog.repository.ExplorationLogRepository;
import com.duodome08.global.exception.custom.AuthorizationException;
import com.duodome08.global.exception.custom.ExplorationLogNotFoundException;
import com.duodome08.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ExplorationLogService {

    private final ExplorationLogRepository explorationLogRepository;

    public ExplorationLogResponseDTO findExplorationLog(Long id) {
        ExplorationLog findExplorationLog = explorationLogRepository.findById(id);

        if (findExplorationLog == null) {
            throw new ExplorationLogNotFoundException("해당하는 탐사일지가 없습니다.");
        }

        return new ExplorationLogResponseDTO(findExplorationLog);
    }

    public List<ExplorationLogResponseDTO> findAllExplorationLogs() {
        List<ExplorationLog> allExplorationLogs = explorationLogRepository.findAll();
        return allExplorationLogs
                .stream()
                .map(ExplorationLogResponseDTO::new)
                .collect(Collectors.toList());
    }

    public ExplorationLogResponseDTO createExplorationLog(ExplorationLogRequestDTO requestDTO, User user) {
        ExplorationLog explorationLog = requestDTO.toEntity();
        explorationLog.setCreatedBy(user.getUserId());
        explorationLogRepository.save(explorationLog);
        return new ExplorationLogResponseDTO(explorationLog);
    }

    public ExplorationLogResponseDTO updateExplorationLog(Long id, ExplorationLogUpdateRequestDTO requestDTO, User user) {
        ExplorationLog findExplorationLog = explorationLogRepository.findById(id);

        if (findExplorationLog == null) {
            throw new ExplorationLogNotFoundException("해당하는 탐사일지가 없습니다.");
        }

        if (!findExplorationLog.getCreatedBy().equals(user.getUserId())) {
            throw new AuthorizationException("접근 할 수 없습니다.");
        }

        findExplorationLog.updateExplorationLog(requestDTO.getTitle(), requestDTO.getBody());
        explorationLogRepository.update(id, findExplorationLog);
        return new ExplorationLogResponseDTO(findExplorationLog);
    }

    public Map<String, String> deleteExplorationLog(Long id, User user) {
        ExplorationLog findExplorationLog = explorationLogRepository.findById(id);

        if (findExplorationLog == null) {
            throw new ExplorationLogNotFoundException("해당하는 탐사일지가 없습니다.");
        }

        if (!findExplorationLog.getCreatedBy().equals(user.getUserId())) {
            throw new AuthorizationException("접근 할 수 없습니다.");
        }
        return Collections.singletonMap("message", "탐사일지 삭제가 완료되었습니다.");
    }
}
