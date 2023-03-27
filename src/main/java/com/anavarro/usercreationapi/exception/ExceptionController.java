package com.anavarro.usercreationapi.exception;

import com.anavarro.usercreationapi.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserNotCreatedException.class)
    public ResponseEntity userNotCreatedHandler(UserNotCreatedException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(MessageDto.builder()
                .message(exception.getMessage())
                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity MethodArgumentNotValidHandler(MethodArgumentNotValidException ex) {

        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(MessageDto.builder()
                .message(errors.stream().collect(Collectors.joining(" | ")))
                .build());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity userNotFoundHandler(UserNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MessageDto.builder()
                .message(exception.getMessage())
                .build());
    }
}
