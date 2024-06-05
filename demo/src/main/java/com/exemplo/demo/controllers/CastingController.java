package com.exemplo.demo.controllers;

import com.exemplo.demo.models.Casting;
import com.exemplo.demo.models.CastingRoles;
import com.exemplo.demo.repository.CastingRepository;
import com.exemplo.demo.repository.CastingRolesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*)")
@RequestMapping(path = "casting")
public class CastingController {

    private CastingRepository castingRepository;

    private CastingRolesRepository castingRolesRepository;

    @GetMapping
    public ResponseEntity<List<Casting>> findAll() {
        List<Casting> Castings = castingRepository.findAll();
        return ResponseEntity.ok(Castings);
    }

}
