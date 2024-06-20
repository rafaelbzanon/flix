package com.exemplo.demo.handler;

import com.exemplo.demo.dto.FaultResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
        log.error("handleExceptions() - message <{}> - Exception : ", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new FaultResponseDTO("500", "Unexpected Error"));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public final ResponseEntity<Object> handleResponseStatusExceptions(ResponseStatusException ex, WebRequest request) {
        if(ex.getStatusCode().value() == HttpStatus.NOT_FOUND.value()) {
            log.info("handleResultExceptions() - ResponseStatusExceptionNotFound :{}", ex.getMessage());
        } else {
            log.info("handleResultExceptions() - ResponseStatusException message <{}> error: ", ex.getMessage(), ex);
        }
        return ResponseEntity.status(ex.getStatusCode()).body(new FaultResponseDTO(String.valueOf(ex.getStatusCode().value()), ex.getReason()));
    }
}
