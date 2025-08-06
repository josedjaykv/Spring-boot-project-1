package com.implementacion.springbootproject1.dto;

import com.implementacion.springbootproject1.models.enums.HighSchoolRole;
import lombok.Data;

@Data
public class CreateBullyDTO {
    private String name;
    private String nickname;
    private HighSchoolRole highSchoolRole;
    private Long cliqueId;
    private String bullyingReason;
    private Integer levelOfAnnoyance;
}