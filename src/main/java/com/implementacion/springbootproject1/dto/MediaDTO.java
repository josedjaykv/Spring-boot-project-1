package com.implementacion.springbootproject1.dto;

import com.implementacion.springbootproject1.models.enums.MediaType;
import lombok.Data;

@Data
public class MediaDTO {
    private Long id;
    private Long revengePlanId;
    private String revengePlanTitle;
    private MediaType type;
    private String url;
    private String caption;
}