package com.acrismatic.acrismatic.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
@Data
@Builder
@EqualsAndHashCode
public class Manual {
    private int manualEntries;
    private int manualExits;
    private LocalDateTime date;
}