package com.acrismatic.acrismatic.repository;

import com.acrismatic.acrismatic.repository.entity.ManualCounterJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManualCounterJpaRepository extends JpaRepository<ManualCounterJpa, Long> {
}
