package com.acrismatic.acrismatic.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecaudacionesIrregulares {
    private String maquina;
    private String cliente;
    private List<RecaudacionIrregular> recaudacionesIrregulares;
}
