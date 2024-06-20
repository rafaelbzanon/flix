package com.exemplo.demo.dto;

import lombok.Data;

@Data
public class FaultResponseDTO {
    private String errorCode;
    private String errorMessage;

    public FaultResponseDTO(String errorCode, String errorMessage) {
        this.setErrorCode(errorCode);
        this.setErrorMessage(errorMessage);
    }
}
