package com.acrismatic.acrismatic.repository;

import com.acrismatic.acrismatic.repository.entity.ContadorManuales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContadorManualesRepository extends JpaRepository<ContadorManuales, Long> {
}
