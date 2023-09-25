package com.mirea.app.controller.exception;

import java.time.LocalDateTime;

public record ExceptionResponseEntity (String exceptionClass, String message, LocalDateTime timestamp) {

}
