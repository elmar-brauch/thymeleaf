package de.bsi.thymeleaf.customer;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler
    public ResponseEntity<Object> handleValidationExceptions(ConstraintViolationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
