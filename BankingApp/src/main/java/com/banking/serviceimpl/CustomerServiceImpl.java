package com.banking.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.advice.CustomerNotFoundException;
import com.banking.dao.CustomerDao;
import com.banking.model.Customer;
import com.banking.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public Customer createCustomer(Customer customer) {
		return customerDao.save(customer);
		
	}

	@Override
	public Customer getCustomer(int customerId)throws CustomerNotFoundException {
		Optional<Customer> customer=customerDao.findById(customerId);
		if(customer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not Found");
		}
		return customerDao.findById(customerId).get();
	}

	@Override
	public boolean deleteCustomer(int customerId) throws CustomerNotFoundException {
		Optional<Customer> customer=customerDao.findById(customerId);
		if(customer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not Found");
		}
		customerDao.deleteById(customerId);
		return true;
	}

}
