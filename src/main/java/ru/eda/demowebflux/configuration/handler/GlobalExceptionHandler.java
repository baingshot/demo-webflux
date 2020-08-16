package ru.eda.demowebflux.configuration.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.eda.demowebflux.controller.api.Response;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static ru.eda.demowebflux.controller.api.Response.failed;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String ERROR_MSG = "Can't finished request. Request was failed with exception.";

    @ExceptionHandler(value = {RuntimeException.class})
    ResponseEntity<Response<?>> handleBaseExceptions(RuntimeException e) {
        log.error(ERROR_MSG, e);
        return responseEntityWith(INTERNAL_SERVER_ERROR, ERROR_MSG);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class, ConstraintViolationException.class})
    ResponseEntity<Response<?>> handleValidationExceptions(Exception e) {
        log.error(ERROR_MSG, e);
        return responseEntityWith(BAD_REQUEST, e.getLocalizedMessage());
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    ResponseEntity<Response<?>> handleDataBaseExceptions(EntityNotFoundException e) {
        log.error(ERROR_MSG, e);
        return responseEntityWith(NOT_FOUND, e.getLocalizedMessage());
    }

    private ResponseEntity<Response<?>> responseEntityWith(HttpStatus httpStatus, String error) {
        return ResponseEntity.status(httpStatus).body(failed(error));
    }
}
