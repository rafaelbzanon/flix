package com.exemplo.demo.service;

import com.exemplo.demo.dto.MediaDTO;
import com.exemplo.demo.entity.Media;
import com.exemplo.demo.repository.MediaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MediaService {
    private final MediaRepository mediaRepository;
    private final GenresServ genreService;

    @Autowired
    public MediaService(MediaRepository mediaRepository, GenresServ genreService) {
        this.mediaRepository = mediaRepository;
        this.genreService = genreService;
    }

    public ResponseEntity<List<MediaDTO>> findAll() {
        List<Media> mediaList = mediaRepository.findAll();

        return ResponseEntity.ok(
                mediaList.stream()
                .map(MediaDTO::fromEntity)
                .collect(Collectors.toList())
        );
    }

    /**
     * Salva ou atualiza uma mídia.
     * @param mediaDTO Payload.
     * @return Mídia atualizada.
     */
    public ResponseEntity<MediaDTO> createOrSaveMedia(MediaDTO mediaDTO) {
        log.info("createMedia() - request: {}", mediaDTO);

        // Erro 400 caso o título esteja vazio.
        if (mediaDTO.getTitle() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O campo 'title' precisa ser informado.");
        }

        // Busca media pelo título no repository
        Optional<Media> optional = mediaRepository.findByTitle(mediaDTO.getTitle());

        // Usa o objeto Media, caso não existir cria um novo objeto.
        Media media = optional.orElseGet(Media::new);

        // Atualiza as informações da mídia.
        media.setTitle(mediaDTO.getTitle());
        media.setDescription(mediaDTO.getDescription());
        media.setRating(mediaDTO.getRating());
        media.setPrice(mediaDTO.getPrice());
        media.setYear(mediaDTO.getYear());
        media.setContentRating(mediaDTO.getContentRating());
        media.setThumbUrl(mediaDTO.getThumbUrl());
        media.setTrailerUrl(mediaDTO.getTrailerUrl());
        media.setEpisodes(mediaDTO.getEpisodes());
        media.setMediaType(mediaDTO.getMediaType());

        // Relacionamentos
        media.setGenre(genreService.createOrSave(mediaDTO.getGenre()));
        // TODO: casting

        // Salva no banco de dados.
        mediaRepository.save(media);
        MediaDTO mediaResponse = MediaDTO.fromEntity(media);

        log.info("createMedia() - success");
        return ResponseEntity.ok(mediaResponse); // Caso atualizar com sucesso, retorna 200.
    }

}
