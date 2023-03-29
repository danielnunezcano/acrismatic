package com.acrismatic.acrismatic.controller.dto;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ManualDTO {
    private int entradasManuales;
    private int salidasManuales;
    private LocalDateTime fecha;
}