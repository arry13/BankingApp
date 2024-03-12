package com.banking.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
		@ResponseStatus(HttpStatus.NOT_FOUND)
		public  String handleCustomerNotFoundException(CustomerNotFoundException e) {
		return e.getMessage();
	}
		
	@ExceptionHandler(AccountNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleAccountNotFoundException(AccountNotFoundException e){
		return e.getMessage();
	}
	@ExceptionHandler(InsufficientFundsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleInsufficientFundsException(InsufficientFundsException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(SameAccountException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleSameAccountException(SameAccountException e) {
		return e.getMessage();
	}

}
