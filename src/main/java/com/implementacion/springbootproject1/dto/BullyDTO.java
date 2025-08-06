package com.implementacion.springbootproject1.dto;

import com.implementacion.springbootproject1.models.enums.HighSchoolRole;
import lombok.Data;

@Data
public class BullyDTO {
    private Long id;
    private String name;
    private String nickname;
    private HighSchoolRole highSchoolRole;
    private String cliqueName;
    private String bullyingReason;
    private Integer levelOfAnnoyance;
    private Integer revengePlansCount;
}