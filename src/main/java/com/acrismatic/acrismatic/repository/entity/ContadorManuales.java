package com.acrismatic.acrismatic.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "contador-manuales")
public class ContadorManuales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer entradas;

    private Integer salidas;

    private LocalDate fecha;

}