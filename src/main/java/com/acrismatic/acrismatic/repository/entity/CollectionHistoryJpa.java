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
@Table(name = "historico_recaudaciones")
public class CollectionHistoryJpa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maquina_id")
    private MachineJpa machine;

    @ManyToOne
    @JoinColumn(name = "contador_manuales_id")
    private ManualCounterJpa manualCounter;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClientJpa client;

    @Column(name = "fecha")
    private LocalDateTime date;

    @Column(name = "importe")
    private Integer amount;
}