package com.example.demo.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdvice {
	
	    @ExceptionHandler(ProductNotAdded.class)
	    @ResponseStatus(value=HttpStatus.NOT_FOUND)
	    ExceptionResponseFormate handelProductNotAddedException(ProductNotAdded pnd,HttpServletRequest req) {
	    	ExceptionResponseFormate erf=new ExceptionResponseFormate();
	    	erf.setError(pnd.getMessage());
	    	erf.setUrl(req.getRequestURI());
	    	return erf;
	    }
	    
	    @ExceptionHandler(ProductNotFound.class)
	    @ResponseStatus(value=HttpStatus.NOT_FOUND)
	    ExceptionResponseFormate handelProductNotFoundException(ProductNotFound pnd,HttpServletRequest req) {
	    	ExceptionResponseFormate erf=new ExceptionResponseFormate();
	    	erf.setError(pnd.getMessage());
	    	erf.setUrl(req.getRequestURI());
	    	return erf;
	    }

}
