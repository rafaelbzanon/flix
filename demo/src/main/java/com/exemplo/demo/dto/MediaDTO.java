package com.exemplo.demo.dto;

import com.exemplo.demo.entity.Media;
import com.exemplo.demo.entity.MediaType;
import lombok.Data;

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
    private String thumbUrl;
    private Integer episodes;
    private String casting;
    private MediaType mediaType;
    private GenreDTO genre;

    public static MediaDTO fromEntity(Media media) {
        MediaDTO dto = new MediaDTO();
        dto.setId(media.getId());
        dto.setTitle(media.getTitle());
        dto.setDescription(media.getDescription());
        dto.setRating(media.getRating());
        dto.setPrice(media.getPrice());
        dto.setYear(media.getYear());
        dto.setContentRating(media.getContentRating());
        dto.setThumbUrl(media.getThumbUrl());
        dto.setTrailerUrl(media.getTrailerUrl());
        dto.setEpisodes(media.getEpisodes());
        dto.setCasting(media.getCasting());
        dto.setMediaType(media.getMediaType());

        // Converte o Genres para GenresDTO
        if (media.getGenre() != null) {
            dto.setGenre(GenreDTO.fromEntity(media.getGenre()));
        }

        return dto;
    }
}
