package com.acrismatic.acrismatic.controller.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MachineDTO {
    private String maquina;
    private String cliente;
    private List<IrregularCollectionDTO> recaudacionesIrregulares;
}