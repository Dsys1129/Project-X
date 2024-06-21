package com.duodome10.explorationLog.repository;

import com.duodome10.explorationLog.ExplorationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExplorationLogRepository extends JpaRepository<ExplorationLog, Long> {

}
