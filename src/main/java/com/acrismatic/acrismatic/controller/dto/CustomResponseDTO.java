package com.acrismatic.acrismatic.controller.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CustomResponseDTO {
    private String machine;
    private String client;
    private List<IrregularCollectionDTO> irregularCollections;
}