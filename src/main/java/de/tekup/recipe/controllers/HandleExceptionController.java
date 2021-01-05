package de.tekup.recipe.controllers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandleExceptionController {
	
	@ExceptionHandler(NoSuchElementException.class)
	public ModelAndView handleNoSuchElementException(NoSuchElementException e) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("404error");
		modelAndView.setStatus(HttpStatus.NOT_FOUND);
		modelAndView.addObject("exception",e);
		
		return modelAndView;
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleNumberFormatException(NumberFormatException e) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("400error");
		modelAndView.setStatus(HttpStatus.BAD_REQUEST);
		modelAndView.addObject("exception",e);
		
		return modelAndView;
	}

}
