package com.exemplo.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Casting {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private CastingRole role;

    @ManyToMany(mappedBy = "casting")
    private List<Media> media;

}
