package com.implementacion.springbootproject1.dto;

import lombok.Data;

@Data
public class CliqueDTO {
    private Long id;
    private String name;
    private String description;
    private Integer bulliesCount;
}