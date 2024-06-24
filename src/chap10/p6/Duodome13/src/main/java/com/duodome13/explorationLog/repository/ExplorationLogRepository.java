package com.duodome13.explorationLog.repository;

import com.duodome13.explorationLog.ExplorationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExplorationLogRepository extends JpaRepository<ExplorationLog, Long> {

}
