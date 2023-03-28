package com.acrismatic.acrismatic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.acrismatic.acrismatic.repository.entity.ClientJpa;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientJpa, Long> {
}