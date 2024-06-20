package com.exemplo.demo.controller;

import com.exemplo.demo.dto.MediaDTO;
import com.exemplo.demo.service.MediaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/v1/media")
@Slf4j
public class MediaController {
    private final MediaService mediaService;

    @Autowired
    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @GetMapping
    public ResponseEntity<List<MediaDTO>> findAll() {
        log.info("findAllMedia() - Buscando todas as mídias...");
        return mediaService.findAll();
    }

    @PostMapping
    public ResponseEntity<MediaDTO> saveOrUpdate(@RequestBody MediaDTO mediaDTO) {
        return mediaService.createOrSaveMedia(mediaDTO);
    }

}
