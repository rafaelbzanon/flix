package com.exemplo.demo.controller;

import com.exemplo.demo.entity.Casting;
import com.exemplo.demo.repository.CastingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "casting")
public class CastingController {

    private CastingRepository castingRepository;

    @GetMapping
    public ResponseEntity<List<Casting>> findAll() {
        List<Casting> Castings = castingRepository.findAll();
        return ResponseEntity.ok(Castings);
    }

}
