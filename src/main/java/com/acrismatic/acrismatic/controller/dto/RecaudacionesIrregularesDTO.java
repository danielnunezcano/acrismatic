package com.acrismatic.acrismatic.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecaudacionesIrregularesDTO {
    private String maquina;
    private String cliente;
    private List<RecaudacionIrregularDTO> recaudacionesIrregulares;
}
