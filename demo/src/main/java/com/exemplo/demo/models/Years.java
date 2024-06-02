package com.exemplo.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Years {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    private String year;
}
