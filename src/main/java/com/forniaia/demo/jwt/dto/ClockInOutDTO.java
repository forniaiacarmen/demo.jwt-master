package com.forniaia.demo.jwt.dto;

import com.forniaia.demo.jwt.enums.ETimeEntryType;

import java.time.LocalDateTime;

public class ClockInOutDTO {
    private Long userId;        // ID del empleado
    private LocalDateTime datetime; // Fecha y hora del fichaje
    private ETimeEntryType type;
}
