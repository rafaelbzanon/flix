package com.exemplo.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    private float rating;

    private float price;

    @ManyToOne
    @JoinColumn(name = "year_id", nullable = false)
    private Years year;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genres genre;

    @ManyToOne
    @JoinColumn(name = "contentRating_id")
    private ContentRating contentRating;

    private String url;

    @ManyToOne
    @JoinColumn(name = "casting_id")
    private Casting casting;

}
