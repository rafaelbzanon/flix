package com.exemplo.demo.controllers;

import com.exemplo.demo.models.Years;
import com.exemplo.demo.repository.YearsRepository;
import com.exemplo.demo.services.YearsServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/years")
public class YearsController {

    @Autowired
    private YearsServ yearsService;

    @GetMapping
    public ResponseEntity<?> getAllYears() {
        return yearsService.getAllYears();
    }

    @PostMapping
    public ResponseEntity<?> createYears(@RequestBody Years years) {
        yearsService.createYear(years);
        return ResponseEntity.ok().body("Year registered with success.");
    }

    @DeleteMapping("{YearsId}")
    public ResponseEntity<?> deleteYearsById(@PathVariable Integer YearsId) {
        yearsService.deleteYearsById(YearsId);
        return ResponseEntity.ok().body("Deleted.");
    }

    @PutMapping("{YearsId}")
    public ResponseEntity<?> updateYears(@PathVariable Integer YearsId, @RequestBody Years years) {
        years.setId(YearsId);
        yearsService.updateYears(YearsId, years);
        return ResponseEntity.ok().body("Year updated with success.");
    }

    @GetMapping("{YearsId}")
    public ResponseEntity<?> getYearsById(@PathVariable Integer YearsId){
        return yearsService.getAllYearsById(YearsId);
    }
}
