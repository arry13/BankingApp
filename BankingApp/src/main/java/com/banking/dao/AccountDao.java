package com.banking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.model.Accounts;

public interface AccountDao extends JpaRepository<Accounts,Integer>{

}
