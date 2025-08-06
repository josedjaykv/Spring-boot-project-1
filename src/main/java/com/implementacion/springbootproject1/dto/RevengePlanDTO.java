package com.implementacion.springbootproject1.dto;

import com.implementacion.springbootproject1.models.enums.SuccessLevel;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RevengePlanDTO {
    private Long id;
    private String title;
    private String description;
    private String bullyName;
    private Boolean isExecuted;
    private LocalDate datePlanned;
    private SuccessLevel successLevel;
    private Integer mediaCount;
}