package com.example.demo.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class ApplicationExceptionHandler {

//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(BookNotFoundException.class)
//	public Map<String, String> handleBusinessBookHandler(BookNotFoundException u) {
//		Map<String, String> errorMap = new HashMap<>();
//		errorMap.put("error Message", u.getMessage());
//		return errorMap;
//	}
	

	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorMessage> BookNotFoundException(BookNotFoundException notFoundException,WebRequest request) {
		ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND, notFoundException.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
        	System.out.println(error+ " " + error.getDefaultMessage());
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
    	ErrorMessage error = new ErrorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }
	
}
