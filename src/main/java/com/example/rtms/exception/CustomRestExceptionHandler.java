package com.example.rtms.exception;

/*
 * @author Kshitij
 * @created 31-Aug-2024
 */

import com.example.rtms.dto.response.ExceptionResponse;
import com.example.rtms.enums.ResponseStatus;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.UnknownHostException;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    private ExceptionResponse setResponse(HttpStatus httpStatus, String message, String error) {
        return new ExceptionResponse(ResponseStatus.FAILURE, httpStatus.value(), message, error);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> entityNotFoundExceptionHandler(final EntityNotFoundException ex) {
        final String error = ex.getLocalizedMessage();
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(setResponse(httpStatus, ex.getMessage(), error), httpStatus);
    }

    @ExceptionHandler({AppException.class})
    public ResponseEntity<Object> appExceptionHandler(final AppException ex) {
        final String error = ex.getLocalizedMessage();
        final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(setResponse(httpStatus, ex.getMessage(), error), httpStatus);
    }

    @ExceptionHandler({UnknownHostException.class})
    public ResponseEntity<Object> unknownHostExceptionHandler(final UnknownHostException ex) {
        final String error = ex.getLocalizedMessage();
        final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(setResponse(httpStatus, ex.getMessage(), error), httpStatus);
    }
}
