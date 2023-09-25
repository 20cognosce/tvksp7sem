package com.mirea.app.controller.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ SQLException.class, DataAccessException.class })
    protected ResponseEntity<ExceptionResponseEntity> handleSqlException(RuntimeException ex) {
        var exceptionResponse = new ExceptionResponseEntity(ex.getClass().getName(), ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ EntityNotFoundException.class })
    protected ResponseEntity<ExceptionResponseEntity> handleNotFoundException(RuntimeException ex) {
        var exceptionResponse = new ExceptionResponseEntity(ex.getClass().getName(), ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
