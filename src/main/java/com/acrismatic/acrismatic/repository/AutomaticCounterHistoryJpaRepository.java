package com.acrismatic.acrismatic.repository;

import com.acrismatic.acrismatic.repository.entity.AutomaticCounterHistoryJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AutomaticCounterHistoryJpaRepository extends JpaRepository<AutomaticCounterHistoryJpa, Long> {

    List<AutomaticCounterHistoryJpa> findByMachineIdAndDateBeforeOrderByDateDesc(Long machineId, LocalDateTime date);
}