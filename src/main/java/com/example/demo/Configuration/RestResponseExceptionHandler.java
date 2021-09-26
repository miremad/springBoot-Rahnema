package com.example.demo.Configuration;

import java.net.http.WebSocket;


import com.example.demo.Model.Exception.EntityNotFoundException;
import com.example.demo.Model.Exception.InvalidInputException;
import lombok.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {
    

    @AllArgsConstructor
    @Data
    static class ExceptionMessage {

        String message;
        Integer id;

    }


    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<Object> handleNotFound(EntityNotFoundException ex, WebRequest request)
    {
		return handleExceptionInternal(ex, new ExceptionMessage(ex.getMessage(), ex.getId()),
                        new HttpHeaders(), HttpStatus.NOT_FOUND,
                        request);
    }


    @ExceptionHandler(value = {InvalidInputException.class})
    protected ResponseEntity<Object> handleNotFound(InvalidInputException ex, WebRequest request)
    {
        return handleExceptionInternal(ex, new ExceptionMessage(ex.getMessage(), ex.getId()),
                new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY,
                request);
    }
}
