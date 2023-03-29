package com.acrismatic.acrismatic.controller.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class IrregularCollectionDTO {
    private int collectionId;
    private int manualId;
    private int automaticId;
    private ManualDTO manuals;
    private AutomaticDTO automatics;
}





