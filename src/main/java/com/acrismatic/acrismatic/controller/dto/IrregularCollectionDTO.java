package com.acrismatic.acrismatic.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class IrregularCollectionDTO {
    private Long collectionId;
    private Long manualId;
    private Long automaticId;
    private Integer manualEntries;
    private Integer manualExits;
    private LocalDateTime manualDates;
    private Integer automaticEntries;
    private Integer automaticExits;
    private LocalDateTime automaticDates;
}
