package com.implementacion.springbootproject1.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateRevengePlanDTO {
    private String title;
    private String description;
    private Long bullyId;
    private LocalDate datePlanned;
}