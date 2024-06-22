package com.duodome11.explorationLog.controller;

import com.duodome11.explorationLog.service.ExplorationLogService;
import com.duodome11.global.argumentresolver.LoginUser;
import com.duodome11.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping
public class ExplorationLogController {

    private final ExplorationLogService explorationLogService;

    @PostMapping("/exploration-logs")
    public ResponseEntity<ExplorationLogResponseDTO> createExplorationLog(@RequestBody ExplorationLogRequestDTO requestDTO,
                                                                          @LoginUser User user) {
        ExplorationLogResponseDTO result = explorationLogService.createExplorationLog(requestDTO, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/exploration-logs/{id}")
    public ResponseEntity<ExplorationLogResponseDTO> findExplorationLog(@PathVariable Long id) {
        ExplorationLogResponseDTO result = explorationLogService.findExplorationLog(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/exploration-logs")
    public ResponseEntity<List<ExplorationLogResponseDTO>> findAllExplorationLogs() {
        List<ExplorationLogResponseDTO> result = explorationLogService.findAllExplorationLogs();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/exploration-logs/{id}")
    public ResponseEntity<ExplorationLogResponseDTO> updateExplorationLog(@PathVariable Long id,
                                                                          @RequestBody ExplorationLogUpdateRequestDTO requestDTO,
                                                                          @LoginUser User user) {
        ExplorationLogResponseDTO result = explorationLogService.updateExplorationLog(id, requestDTO, user);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/exploration-logs/{id}")
    public ResponseEntity<Map<String, String>> createExplorationLog(@PathVariable Long id,
                                                                    @LoginUser User user) {
        Map<String, String> result = explorationLogService.deleteExplorationLog(id, user);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
