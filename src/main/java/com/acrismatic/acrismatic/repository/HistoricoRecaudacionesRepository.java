package com.acrismatic.acrismatic.repository;

import com.acrismatic.acrismatic.repository.entity.HistoricoRecaudaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRecaudacionesRepository extends JpaRepository<HistoricoRecaudaciones, Long> {
}