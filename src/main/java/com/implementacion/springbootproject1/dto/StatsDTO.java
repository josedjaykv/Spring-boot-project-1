package com.implementacion.springbootproject1.dto;

import lombok.Data;

@Data
public class StatsDTO {
    private Long totalBullies;
    private Long totalRevengePlans;
    private Long executedPlans;
    private Long pendingPlans;
    private Double averageMoodLevel;
    private String mostAnnoyingBully;
    private String topClique;
}