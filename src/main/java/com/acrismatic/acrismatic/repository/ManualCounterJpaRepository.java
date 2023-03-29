package com.acrismatic.acrismatic.repository;

import com.acrismatic.acrismatic.repository.entity.ManualCounterJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManualCounterJpaRepository extends JpaRepository<ManualCounterJpa, Long> {

    List<ManualCounterJpa> findByMachineId(Long machineId);

}
