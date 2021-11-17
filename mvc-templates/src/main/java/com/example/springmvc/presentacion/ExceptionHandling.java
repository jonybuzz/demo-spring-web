package com.example.springmvc.presentacion;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIllegalArgumentException(IOException e) {
        return ResponseEntity.status(400).body("Vuelva pronto! " + e);
    }

}
