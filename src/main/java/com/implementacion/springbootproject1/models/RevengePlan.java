package com.implementacion.springbootproject1.models;

import com.implementacion.springbootproject1.models.enums.SuccessLevel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "revenge_plans")
@Data
public class RevengePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "bully_id", nullable = false)
    private Bully bully;

    private Boolean isExecuted = false;

    private LocalDate datePlanned;

    @Enumerated(EnumType.STRING)
    private SuccessLevel successLevel;

    @OneToMany(mappedBy = "revengePlan", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Media> mediaEntries;
}