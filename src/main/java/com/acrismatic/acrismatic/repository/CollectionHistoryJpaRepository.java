package com.acrismatic.acrismatic.repository;

import com.acrismatic.acrismatic.repository.entity.CollectionHistoryJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionHistoryJpaRepository extends JpaRepository<CollectionHistoryJpa, Long> {

}