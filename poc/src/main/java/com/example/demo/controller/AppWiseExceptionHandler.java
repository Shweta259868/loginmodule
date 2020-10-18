package com.example.demo.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.POCException;

@ControllerAdvice
public class AppWiseExceptionHandler {
	
	@ExceptionHandler(POCException.class)
	public String duplicate() {
		return "error/duplicate";
	}

}
