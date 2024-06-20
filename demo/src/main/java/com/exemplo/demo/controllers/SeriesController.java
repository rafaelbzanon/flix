package com.exemplo.demo.controllers;


import com.exemplo.demo.models.Series;
import com.exemplo.demo.services.SeriesServ;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/series")

public class SeriesController {
    @Autowired
    private SeriesServ seriesService;

    @GetMapping
    public ResponseEntity<?> getAllYears(){
        return seriesService.getAllSeries();
    }

    @PostMapping
    public  ResponseEntity<?> createSeries(@RequestBody Series series) {
        seriesService.createSeries(series);
        return ResponseEntity.ok().body("Series registered with success");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteSeries(@PathVariable Integer SeriesId){
        seriesService.deleteSeriesById(SeriesId);
        return ResponseEntity.ok().body("Deleted.");
    }

    @PutMapping("{SeriesId}")
    public ResponseEntity<?> updateSeries(@PathVariable Integer SeriesId, @RequestBody Series series){
        series.setId(SeriesId);
        seriesService.updateSeries(SeriesId, series);
        return ResponseEntity.ok().body("Series updated with success");
    }

    @GetMapping("{SeriesId}")
    public ResponseEntity<?> getSeriesById(@PathVariable Integer SeriesId){
        return ResponseEntity.ok().body("Series updated with success");
    }
}
