package com.acrismatic.acrismatic.repository;

import com.acrismatic.acrismatic.repository.entity.AutomaticCounterHistoryJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomaticCounterHistoryJpaRepository extends JpaRepository<AutomaticCounterHistoryJpa, Long> {
}