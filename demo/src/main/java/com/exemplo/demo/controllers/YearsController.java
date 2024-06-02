package com.exemplo.demo.controllers;

import com.exemplo.demo.models.Years;
import com.exemplo.demo.repository.YearsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1/years")
public class YearsController {

    @Autowired
    private YearsRepository yearsRepository;

    @GetMapping
    public ResponseEntity<List<Years>> findAll() {
        return ResponseEntity.ok(yearsRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Years> save(@RequestBody Years years) {
        return ResponseEntity.ok(yearsRepository.save(years));
    }

    @DeleteMapping
    public ResponseEntity<Years> delete(@RequestBody Years years) {
        yearsRepository.delete(years);
        return ResponseEntity.ok(years);
    }

    @PutMapping
    public ResponseEntity<Years> update(@RequestBody Years years) {
        yearsRepository.save(years);
        return ResponseEntity.ok(years);
    }

}
