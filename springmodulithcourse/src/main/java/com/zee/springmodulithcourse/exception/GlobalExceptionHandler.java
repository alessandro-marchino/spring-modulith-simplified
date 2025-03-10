package com.zee.springmodulithcourse.exception;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Map<String, List<String>>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		List<String> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
			.map(FieldError::getDefaultMessage)
			.toList();
		return new ResponseEntity<>(toErrorMap(fieldErrors), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ModulithException.class)
	public ResponseEntity<Response> handleModulithException(ModulithException ex) {
		return new ResponseEntity<>(new Response(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Response> handleRuntimeException(RuntimeException ex) {
		return new ResponseEntity<>(new Response(ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private Map<String, List<String>> toErrorMap(List<String> fieldErrors) {
		return Map.of("errors", fieldErrors);
	}

}
