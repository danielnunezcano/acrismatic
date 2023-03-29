package com.acrismatic.acrismatic.controller.dto;

import lombok.*;

import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ManualDTO {
    private int manualEntries;
    private int manualExits;
    private LocalDateTime date;
}