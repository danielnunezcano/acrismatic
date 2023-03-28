package com.acrismatic.acrismatic.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class IrregularCollectionsDTO {
    private String machine;
    private String client;
    private List<IrregularCollectionDTO> irregularCollections;
}
