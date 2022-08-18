package com.totalshakes.wstotalshakes.controller;

import com.totalshakes.wstotalshakes.domain.model.ErrorDto;
import com.totalshakes.wstotalshakes.exception.IngredienteJaCadastrado;
import com.totalshakes.wstotalshakes.exception.IngredienteNaoEncontrado;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception e) {
        log.error("Error");
        var errorDto =
                ErrorDto.builder()
                        .message(e.getMessage())
                        .error(HttpStatus.BAD_REQUEST)
                        .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }

    @ExceptionHandler(value = IngredienteNaoEncontrado.class)
    public ResponseEntity<ErrorDto> handleValidationIngredienteNaoEncontrado(IngredienteNaoEncontrado e) {
        log.error("Erro de ingrediente nao encontrado ");
        var errorDto =
                ErrorDto.builder()
                        .message(e.getMessage())
                        .error(HttpStatus.NOT_FOUND)
                        .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }

    @ExceptionHandler(value = IngredienteJaCadastrado.class)
    public ResponseEntity<ErrorDto> handleValidationIngredienteJaCadastrado(IngredienteJaCadastrado e) {
        log.error("Erro de ingrediente ja cadastrado");
        var errorDto =
                ErrorDto.builder()
                        .message(e.getMessage())
                        .error(HttpStatus.BAD_REQUEST)
                        .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }
}