package com.acrismatic.acrismatic.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode
public class CustomResponse {
    private String machine;
    private String client;
    private List<IrregularCollection> irregularCollections;
}