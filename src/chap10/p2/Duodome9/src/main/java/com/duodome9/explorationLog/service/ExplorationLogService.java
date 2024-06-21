package com.duodome9.explorationLog.service;

import com.duodome9.explorationLog.ExplorationLog;
import com.duodome9.explorationLog.controller.ExplorationLogRequestDTO;
import com.duodome9.explorationLog.controller.ExplorationLogResponseDTO;
import com.duodome9.explorationLog.controller.ExplorationLogUpdateRequestDTO;
import com.duodome9.explorationLog.repository.ExplorationLogRepository;
import com.duodome9.global.exception.custom.AuthorizationException;
import com.duodome9.global.exception.custom.ExplorationLogNotFoundException;
import com.duodome9.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ExplorationLogService {

    private final ExplorationLogRepository explorationLogRepository;

    @Transactional(readOnly = true)
    public ExplorationLogResponseDTO findExplorationLog(Long id) {
        ExplorationLog findExplorationLog = explorationLogRepository.findById(id);

        if (findExplorationLog == null) {
            throw new ExplorationLogNotFoundException("해당하는 탐사일지가 없습니다.");
        }

        return new ExplorationLogResponseDTO(findExplorationLog);
    }

    @Transactional(readOnly = true)
    public List<ExplorationLogResponseDTO> findAllExplorationLogs() {
        List<ExplorationLog> allExplorationLogs = explorationLogRepository.findAll();
        return allExplorationLogs
                .stream()
                .map(ExplorationLogResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ExplorationLogResponseDTO createExplorationLog(ExplorationLogRequestDTO requestDTO, User user) {
        ExplorationLog explorationLog = requestDTO.toEntity();
        explorationLog.setCreatedBy(user.getUserId());
        explorationLogRepository.save(explorationLog);
        return new ExplorationLogResponseDTO(explorationLog);
    }

    @Transactional
    public ExplorationLogResponseDTO updateExplorationLog(Long id, ExplorationLogUpdateRequestDTO requestDTO, User user) {
        ExplorationLog findExplorationLog = explorationLogRepository.findById(id);

        if (findExplorationLog == null) {
            throw new ExplorationLogNotFoundException("해당하는 탐사일지가 없습니다.");
        }

        if (!findExplorationLog.getCreatedBy().equals(user.getUserId())) {
            throw new AuthorizationException("접근 할 수 없습니다.");
        }

        findExplorationLog.updateExplorationLog(requestDTO.getTitle(), requestDTO.getBody());
        explorationLogRepository.update(id, requestDTO.getTitle(), requestDTO.getBody());
        return new ExplorationLogResponseDTO(findExplorationLog);
    }

    @Transactional
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
