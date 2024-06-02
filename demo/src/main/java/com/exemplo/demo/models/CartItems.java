package com.exemplo.demo.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "movies_id", nullable = true)
    private Movies movies;

    @ManyToOne
    @JoinColumn(name = "series_id", nullable = true)
    private Series series;
}
