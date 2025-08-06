package com.implementacion.springbootproject1.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MoodTrackerDTO {
    private Long id;
    private LocalDate date;
    private Integer moodLevel;
    private String note;
}