package com.exemplo.demo.dto;

import com.exemplo.demo.entity.Media;
import com.exemplo.demo.entity.MediaType;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class MediaDTO {
    private Integer id;
    private String title;
    private String description;
    private float rating;
    private float price;
    private int year;
    private String contentRating;
    private String trailerUrl;
    private Integer episodes;
    private MediaType mediaType;
    private GenreDTO genre;
    private List<CastingDTO> casting;

    public static MediaDTO fromEntity(Media media) {
        MediaDTO dto = new MediaDTO();
        dto.setId(media.getId());
        dto.setTitle(media.getTitle());
        dto.setDescription(media.getDescription());
        dto.setRating(media.getRating());
        dto.setPrice(media.getPrice());
        dto.setYear(media.getYear());
        dto.setContentRating(media.getContentRating());
        dto.setTrailerUrl(media.getTrailerUrl());
        dto.setEpisodes(media.getEpisodes());
        dto.setMediaType(media.getMediaType());

        // Converte o Genres para GenresDTO
        if (media.getGenre() != null) {
            dto.setGenre(GenreDTO.fromEntity(media.getGenre()));
        }

        // Converte a lista de Casting para List<CastingDTO>
        if (media.getCasting() != null) {
            List<CastingDTO> castingDTOs = media.getCasting().stream()
                    .map(CastingDTO::fromEntity)
                    .collect(Collectors.toList());
            dto.setCasting(castingDTOs);
        }

        return dto;
    }
}
