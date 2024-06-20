package com.exemplo.demo.services;

import com.exemplo.demo.models.*;
import com.exemplo.demo.repository.*;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SeriesServ {
    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private GenresRepository genresRepository;
    @Autowired
    private YearsRepository yearsRepository;
    @Autowired
    private ContentRatingRepository contentRatingRepository;
    @Autowired
    private CastingRepository castingRepository;

    public void createSeries(Series series) {
        if (series.getGenre() != null && series.getGenre().getId() != null) {
            Genres genre = genresRepository.findById(series.getGenre().getId())
                    .orElseThrow(() -> new RuntimeException("Genre not found"));
            series.setGenre(genre);
        }

        if (series.getYear() != null && series.getYear().getId() != null) {
            Years year = yearsRepository.findById(series.getYear().getId())
                    .orElseThrow(() -> new RuntimeException("Year not found"));
            series.setYear(year);
        }

        if (series.getContentRating() != null && series.getContentRating().getId() != null) {
            ContentRating contentRating = contentRatingRepository.findById(series.getContentRating().getId())
                    .orElseThrow(() -> new RuntimeException("Content Rating not found"));
            series.setContentRating(contentRating);
        }

        if (series.getCasting() != null && series.getCasting().getId() != null) {
            Casting casting = castingRepository.findById(series.getCasting().getId())
                    .orElseThrow(() -> new RuntimeException("Casting not found"));
            series.setCasting(casting);
        }
    }

    public ResponseEntity<?> updateSeries(Integer SeriesId, Series series) {
        if (seriesRepository.findById(SeriesId).isPresent()) {
            Series seriesToUpdate = seriesRepository.findById(SeriesId).get();
            seriesToUpdate.setCasting(series.getCasting());
            seriesToUpdate.setYear(series.getYear());
            seriesToUpdate.setGenre(series.getGenre());
            seriesToUpdate.setPrice(series.getPrice());
            seriesToUpdate.setUrl(series.getUrl());
            seriesToUpdate.setEpisodes(series.getEpisodes());
            seriesToUpdate.setRating(series.getRating());
            seriesToUpdate.setTitle(series.getTitle());
            seriesToUpdate.setDescription(series.getDescription());
            seriesToUpdate.setContentRating(series.getContentRating());
            return ResponseEntity.ok().body("Update made with success!");
        }
        else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("An Error Occurred");
        }

    }
    public ResponseEntity<?> getAllSeries(){
        List<Series> series = seriesRepository.findAll();
        if (series.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("An error was found.");
        }
        return ResponseEntity.ok().body(series);
    }

    public ResponseEntity<?> getAllSeriesById(Integer SeriesId){
        if (seriesRepository.existsById(SeriesId)){
            Series series = seriesRepository.findById(SeriesId).get();
            return ResponseEntity.ok().body(series);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nothing found.");
        }
    }

    public ResponseEntity<?> deleteSeriesById(Integer SeriesId){
        if (seriesRepository.existsById(SeriesId)) {
            seriesRepository.deleteById(SeriesId);
            return ResponseEntity.ok().body("Id deleted");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nothing Found");
        }
    }
}
