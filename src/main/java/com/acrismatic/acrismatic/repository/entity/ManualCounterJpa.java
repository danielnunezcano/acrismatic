package com.acrismatic.acrismatic.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contador_manuales")
public class ManualCounterJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maquina_id")
    private MachineJpa machine;

    @Column(name = "entradas")
    private Integer entries;

    @Column(name = "salidas")
    private Integer exits;

    @Column(name = "fecha")
    private LocalDateTime date;
}