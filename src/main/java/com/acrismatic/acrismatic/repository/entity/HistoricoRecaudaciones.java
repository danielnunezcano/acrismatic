package com.acrismatic.acrismatic.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "historico-recaudaciones")
public class HistoricoRecaudaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private Double importe;

    @ManyToOne
    private Maquina maquina;

    @ManyToOne
    private ContadorManuales contadorManuales;

    @ManyToOne
    private Cliente cliente;
}