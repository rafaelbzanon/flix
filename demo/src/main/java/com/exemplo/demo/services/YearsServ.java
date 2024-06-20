package com.exemplo.demo.services;

import com.exemplo.demo.models.Years;
import com.exemplo.demo.repository.YearsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service


public class YearsServ {
    @Autowired
    private YearsRepository yearsRepository;

    public void createYear(Years years) {
        yearsRepository.save(years);
    }

    public ResponseEntity<?> updateYears(Integer YearsId, Years years) {
        if (yearsRepository.findById(YearsId).isPresent()) {
            Years yearsToUpdate = yearsRepository.findById(YearsId).get();
            yearsToUpdate.setYear(years.getYear());
            yearsRepository.save(yearsToUpdate);
            return ResponseEntity.ok().body("Year updated with success.");
        } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("An error occurred.");
        }
    }

    public ResponseEntity<?> getAllYears(){
        List<Years> years = yearsRepository.findAll();
        if (years.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nothing was found.");
        }
        return ResponseEntity.ok().body(years);
    }

    public ResponseEntity<?> getAllYearsById(Integer YearsId){
        if (yearsRepository.existsById(YearsId)){
            Years year = yearsRepository.findById(YearsId).get();
            return ResponseEntity.ok().body(year);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nothing found.");
        }
    }
    public ResponseEntity<?> deleteYearsById(Integer YearsId){
        if (yearsRepository.existsById(YearsId)){
            yearsRepository.deleteById(YearsId);
            return ResponseEntity.ok().body("Id deleted.");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id not found.");
        }
    }
}

