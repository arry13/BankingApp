package com.banking.service;

import com.banking.advice.*;
import com.banking.model.Customer;

public interface CustomerService {

	public Customer createCustomer (Customer customer) ;
	
	public Customer getCustomer (int customerId)throws CustomerNotFoundException;
	
	public boolean deleteCustomer(int customerId)throws CustomerNotFoundException;
		
	
}
