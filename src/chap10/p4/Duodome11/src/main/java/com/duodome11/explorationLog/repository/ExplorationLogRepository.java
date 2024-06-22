package com.duodome11.explorationLog.repository;

import com.duodome11.explorationLog.ExplorationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExplorationLogRepository extends JpaRepository<ExplorationLog, Long> {

}
