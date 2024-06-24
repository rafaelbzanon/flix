package com.exemplo.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(of = {"title"})
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String title;

    private String description;

    private float rating;

    private float price;

    private int year;

    private String contentRating;

    private String thumbUrl;

    private String trailerUrl;

    // Campo específico para séries. Pode ser nulo para filmes
    private Integer episodes;

    // Campo para diferenciar entre série e filme
    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genres genre;

    @Column(length = 512)
    private String casting;

}
