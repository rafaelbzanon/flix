package com.exemplo.demo.controllers;

import com.exemplo.demo.models.CastingRoles;
import com.exemplo.demo.repository.CastingRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/castingroles")
public class CastingRolesController {

    @Autowired
    private CastingRolesRepository rolesRepository;

    @GetMapping
    public List<CastingRoles> findAll() {
        return rolesRepository.findAll();
    }

    @PostMapping
    public CastingRoles save(@RequestBody CastingRoles role) {
        return rolesRepository.save(role);
    }

    @PutMapping
    public ResponseEntity<CastingRoles> update(@RequestBody CastingRoles role) {
        rolesRepository.save(role);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping
    public ResponseEntity<CastingRoles> delete(@RequestBody CastingRoles role) {
        rolesRepository.delete(role);
        return ResponseEntity.ok(role);
    }

}