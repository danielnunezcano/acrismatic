package com.acrismatic.acrismatic.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class IrregularCollections {
    private String machine;
    private String client;
    private List<IrregularCollection> irregularCollections;
}
