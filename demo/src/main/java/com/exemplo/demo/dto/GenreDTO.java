package com.exemplo.demo.dto;

import com.exemplo.demo.entity.Genres;
import lombok.Data;

@Data
public class GenreDTO {
    private Integer id;
    private String name;

    public static GenreDTO fromEntity(Genres entity) {
        if (entity == null) return null;
        GenreDTO genresDTO = new GenreDTO();
        genresDTO.setId(entity.getId());
        genresDTO.setName(entity.getName());
        return genresDTO;
    }

    public static Genres toEntity(GenreDTO dto) {
        if (dto == null) return null;
        Genres genre = new Genres();
        genre.setId(dto.getId());
        genre.setName(dto.getName());
        return genre;
    }
}
