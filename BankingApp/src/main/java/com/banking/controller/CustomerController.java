package com.banking.controller;

import org.slf4j.event.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.Customer;
import com.banking.service.CustomerService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(value="/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/createcustomer")
	public ResponseEntity<Customer> createCustomer(Customer customer){
		
		Customer cust=customerService.createCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
		}
	
	@GetMapping("/getcustomer")
		public ResponseEntity<Customer> getCustomer(int customerId){
			Customer cust=customerService.getCustomer(customerId);
			return new ResponseEntity<Customer>(cust,HttpStatus.OK);
			
		}
	@DeleteMapping("/deletecustomer")
	public ResponseEntity<Boolean> deleteCustomer(int customerId){
		Boolean res=customerService.deleteCustomer(customerId);
		return new ResponseEntity<Boolean>(res,HttpStatus.OK);
	}
	}


