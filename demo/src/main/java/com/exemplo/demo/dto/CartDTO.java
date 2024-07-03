package com.exemplo.demo.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CartDTO {
    private Integer id;
    private List<MediaDTO> cartItems;
    private LocalDateTime createdAt;
}
