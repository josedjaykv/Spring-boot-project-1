package com.implementacion.springbootproject1.models;

import com.implementacion.springbootproject1.models.enums.MediaType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "media")
@Data
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "revenge_plan_id", nullable = false)
    private RevengePlan revengePlan;

    @Enumerated(EnumType.STRING)
    private MediaType type;

    private String url;

    private String caption;
}