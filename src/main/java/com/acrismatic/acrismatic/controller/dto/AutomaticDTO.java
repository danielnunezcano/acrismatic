package com.acrismatic.acrismatic.controller.dto;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AutomaticDTO {
    private int automaticEntries;
    private int automaticExists;
    private LocalDateTime date;
}