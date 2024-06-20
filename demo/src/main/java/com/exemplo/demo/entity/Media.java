package com.exemplo.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    private float rating;

    private float price;

    private int year;

    private String contentRating;

    private String trailerUrl;

    // Campo específico para séries. Pode ser nulo para filmes
    private Integer episodes;

    // Campo para diferenciar entre série e filme
    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = true)
    private Genres genre;

    @ManyToMany
    @JoinTable(
            name = "media_casting",
            joinColumns = @JoinColumn(name = "media_id"),
            inverseJoinColumns = @JoinColumn(name = "casting_id",
            nullable = true)
    )
    private List<Casting> casting;
}
