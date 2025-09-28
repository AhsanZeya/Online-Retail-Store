package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdvice {
	
	    @ExceptionHandler(OrderNotAddedException.class)
	    @ResponseStatus(value=HttpStatus.NOT_FOUND)
	    ExceptionResponseFormate handelProductNotAddedException(OrderNotAddedException pnd,HttpServletRequest req) {
	    	ExceptionResponseFormate erf=new ExceptionResponseFormate();
	    	erf.setError(pnd.getMessage());
	    	erf.setUrl(req.getRequestURI());
	    	return erf;
	    }
	    
	    @ExceptionHandler(OrderNotFoundException.class)
	    @ResponseStatus(value=HttpStatus.NOT_FOUND)
	    ExceptionResponseFormate handelProductNotFoundException(OrderNotFoundException pnd,HttpServletRequest req) {
	    	ExceptionResponseFormate erf=new ExceptionResponseFormate();
	    	erf.setError(pnd.getMessage());
	    	erf.setUrl(req.getRequestURI());
	    	return erf;
	    }

}
