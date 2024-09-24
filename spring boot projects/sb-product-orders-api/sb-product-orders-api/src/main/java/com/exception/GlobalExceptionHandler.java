package com.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice				// this class can contains more than one method with @ExceptionHandler 
public class GlobalExceptionHandler {

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> validationExceptionHandler(MethodArgumentNotValidException e){
		Map<String, String> mm = new HashMap<String, String>();
		e.getBindingResult().getFieldErrors().forEach(ee-> mm.put(ee.getField(), ee.getDefaultMessage()));
		return ResponseEntity.ok(mm);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception e){
		return ResponseEntity.ok("Global Message "+e.toString());
	}
}
