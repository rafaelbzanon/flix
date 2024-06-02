package com.exemplo.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Casting {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "castingRoles_id", nullable = false)
    private CastingRoles castingRoles;
}
