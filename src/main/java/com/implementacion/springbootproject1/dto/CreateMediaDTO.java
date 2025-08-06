package com.implementacion.springbootproject1.dto;

import com.implementacion.springbootproject1.models.enums.MediaType;
import lombok.Data;

@Data
public class CreateMediaDTO {
    private Long revengePlanId;
    private MediaType type;
    private String url;
    private String caption;
}