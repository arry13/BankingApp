package com.banking.advice;

public class InsufficientFundsException extends RuntimeException {
	public InsufficientFundsException() {
		// TODO Auto-generated constructor stub
	}
	public InsufficientFundsException(String message) {
		super(message);
	}

}
