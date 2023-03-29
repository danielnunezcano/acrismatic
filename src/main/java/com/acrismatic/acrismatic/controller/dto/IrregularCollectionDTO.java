package com.acrismatic.acrismatic.controller.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class IrregularCollectionDTO {
    private int idRecaudacion;
    private int idManual;
    private int idAutomatico;
    private ManualDTO manuales;
    private AutomaticDTO automaticos;
}
