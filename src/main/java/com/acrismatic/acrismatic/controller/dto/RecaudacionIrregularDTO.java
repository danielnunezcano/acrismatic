package com.acrismatic.acrismatic.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RecaudacionIrregularDTO {
    private Long idRecaudacion;
    private Long idManual;
    private Long idAutomatico;
    private Integer entradasManuales;
    private Integer salidasManuales;
    private LocalDateTime fechaManuales;
    private Integer entradasAutomaticas;
    private Integer salidasAutomaticas;
    private LocalDateTime fechaAutomaticas;
}
