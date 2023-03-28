package com.acrismatic.acrismatic.repository;

import com.acrismatic.acrismatic.repository.entity.MachineJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineJpaRepository extends JpaRepository<MachineJpa, Long> {
}