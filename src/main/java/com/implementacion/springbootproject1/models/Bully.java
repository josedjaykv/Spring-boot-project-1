package com.implementacion.springbootproject1.models;

import com.implementacion.springbootproject1.models.enums.HighSchoolRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "bullies")
@Data
public class Bully {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private HighSchoolRole highSchoolRole;

    @ManyToOne
    @JoinColumn(name = "clique_id")
    private Clique clique;

    private String bullyingReason;

    @Column(nullable = false)
    private Integer levelOfAnnoyance; // 1-10

    @OneToMany(mappedBy = "bully", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<RevengePlan> revengePlans;
}