package com.exemplo.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ListDTO {
    private Integer id;
    private List<MediaDTO> listItems;
    private LocalDateTime createdAt;
}
