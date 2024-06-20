package com.exemplo.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Data
public class Series {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String title;

    private String description;

    private int episodes;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = true)
    private Genres genre;

    @ManyToOne
    @JoinColumn(name = "year_id", nullable = true)
    private Years year;

    @ManyToOne
    @JoinColumn(name = "contentRating_id", nullable = true)
    private ContentRating contentRating;

    private float rating;

    private float price;

    private String url;

    @ManyToOne
    @JoinColumn(name = "casting_id", nullable = true)
    private Casting casting;

}
