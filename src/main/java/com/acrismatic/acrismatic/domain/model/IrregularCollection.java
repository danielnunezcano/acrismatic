package com.acrismatic.acrismatic.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class IrregularCollection {
    private long collectionId;
    private long manualId;
    private long automaticId;
    private Manual manuals;
    private Automatic automatics;
}
