package com.acrismatic.acrismatic.repository.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "maquina")
public class Maquina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @ManyToOne
    private Cliente cliente;

}