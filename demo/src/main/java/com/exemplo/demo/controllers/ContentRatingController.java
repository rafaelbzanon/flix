package com.exemplo.demo.controllers;

import com.exemplo.demo.models.ContentRating;
import com.exemplo.demo.repository.ContentRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/contentrating")
public class ContentRatingController {

    @Autowired
    private ContentRatingRepository contentRatingRepository;

    @GetMapping
    public ResponseEntity<List<ContentRating>> findAll() {
        List<ContentRating> contentRatings = contentRatingRepository.findAll();
        return ResponseEntity.ok(contentRatings);
    }

    @PostMapping
    public ResponseEntity<ContentRating> save(@RequestBody ContentRating contentRating) {
        ContentRating contentRatingSaved = contentRatingRepository.save(contentRating);
        return ResponseEntity.ok(contentRatingSaved);
    }

    @PutMapping
    public ResponseEntity<ContentRating> update(@RequestBody ContentRating contentRating) {
        ContentRating contentRatingSaved = contentRatingRepository.save(contentRating);
        return ResponseEntity.ok(contentRatingSaved);
    }

    @DeleteMapping
    public ResponseEntity<ContentRating> delete(@RequestBody ContentRating contentRating) {
        contentRatingRepository.delete(contentRating);
        return ResponseEntity.ok(contentRating);
    }

}
