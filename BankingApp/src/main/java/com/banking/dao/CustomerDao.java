package com.banking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.model.Customer;

public interface CustomerDao extends JpaRepository<Customer,Integer> {

}
