package com.acrismatic.acrismatic.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "historico-contadores-automaticos")
public class HistoricoContadoresAutomaticos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer entradas;

    private Integer salidas;

    private LocalDateTime fecha;

}