package com.exemplo.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Series {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String title;

    private String description;

    private int episodes;

    @ManyToOne
    @JoinColumn(name = "genre_id", nullable = false)
    private Genres genre;

    @ManyToOne
    @JoinColumn(name = "year_id", nullable = false)
    private Years year;

    @ManyToOne
    @JoinColumn(name = "contentRating_id", nullable = false)
    private ContentRating contentRating;

    private float rating;

    private float price;

    private String url;

    @ManyToOne
    @JoinColumn(name = "casting_id", nullable = false)
    private Casting casting;

}
