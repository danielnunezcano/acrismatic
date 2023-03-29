package com.acrismatic.acrismatic.domain.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
@Data
@Builder
@EqualsAndHashCode
public class Automatic {
    private int automaticEntries;
    private int automaticExists;
    private LocalDateTime date;
}