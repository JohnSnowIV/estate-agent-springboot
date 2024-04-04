package com.estates.project.exceptions;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        if(e.getMessage().equals("No value present")){
            return new ResponseEntity<>(e.getMessage()+" 404" , HttpStatus.NOT_FOUND);
        }

            return new ResponseEntity<>(e.getMessage()+" 400" , HttpStatus.BAD_REQUEST);


    }
}
//
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseBody
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    private Response handleMessage(RuntimeException e) {
//        Response response = new Response();
//        response.setTimestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
//        response.setError("Not Found");
//        response.setStatus(404);
//        response.setException("com.TaskNotFoundException");
//        response.setMessage("Unknown Task");
//        return response;

