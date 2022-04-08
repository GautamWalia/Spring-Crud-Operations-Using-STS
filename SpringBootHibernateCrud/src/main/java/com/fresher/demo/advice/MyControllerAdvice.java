package com.fresher.demo.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fresher.demo.custom.exception.EmptyInputException;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler
{
		@ExceptionHandler(EmptyInputException.class)
		public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException)
		{
			return new ResponseEntity<String>("Input Field is empty, Please fill the field correctly", HttpStatus.BAD_REQUEST);
		}
		
		//@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
		@Override
		protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException methodNotSupportedException,
											HttpHeaders headers, HttpStatus status, WebRequest request)
		{
			return new ResponseEntity<Object>("Selected method for this request is not supported, Please change your request", HttpStatus.BAD_REQUEST);
		}
		
		@ExceptionHandler(NoSuchElementException.class)
		public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException)
		{
			return new ResponseEntity<String>("Entered Field not exist in database, Please change your request", HttpStatus.NOT_FOUND);
		}
}
