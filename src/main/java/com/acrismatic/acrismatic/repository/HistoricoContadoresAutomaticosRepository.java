package com.acrismatic.acrismatic.repository;

import com.acrismatic.acrismatic.repository.entity.HistoricoContadoresAutomaticos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoContadoresAutomaticosRepository extends JpaRepository<HistoricoContadoresAutomaticos, Long> {
}