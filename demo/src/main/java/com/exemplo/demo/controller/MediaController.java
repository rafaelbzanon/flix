package com.exemplo.demo.controller;

import com.exemplo.demo.dto.MediaDTO;
import com.exemplo.demo.entity.Media;
import com.exemplo.demo.service.MediaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/media")
@CrossOrigin(origins = "*")
@AllArgsConstructor
@Slf4j
public class MediaController {
    private final MediaService mediaService;

    @GetMapping
    public ResponseEntity<List<MediaDTO>> findAll() {
        log.info("findAllMedia() - Buscando todas as mídias...");
        return mediaService.findAll();
    }

    @PostMapping
    public ResponseEntity<MediaDTO> saveOrUpdate(@RequestBody MediaDTO mediaDTO) {
        return mediaService.createOrSaveMedia(mediaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MediaDTO> getMediaById(@PathVariable Integer id) {
        Optional<Media> mediaOptional = mediaService.findById(id);
        if (mediaOptional.isPresent()) {
            return ResponseEntity.ok(MediaDTO.fromEntity(mediaOptional.get()));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mídia não encontrada");
        }
    }

}
