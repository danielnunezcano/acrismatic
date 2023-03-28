package com.acrismatic.acrismatic.repository;

import com.acrismatic.acrismatic.repository.entity.CollectionHistoryJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionHistoryJpaRepository extends JpaRepository<CollectionHistoryJpa, Long> {

    @Query("SELECT ch FROM CollectionHistoryJpa ch " +
            "JOIN ch.manualCounter mc " +
            "JOIN ch.machine m " +
            "JOIN AutomaticCounterHistoryJpa ac ON ac.machine = m " +
            "WHERE mc.entries != ac.entries " +
            "AND mc.date < ac.date " +
            "AND (mc.date, mc.machine) IN (SELECT max(mc2.date), mc2.machine FROM ManualCounter mc2 GROUP BY mc2.machine)")
    List<CollectionHistoryJpa> findMismatchedManualAndAutomaticCounters();
}