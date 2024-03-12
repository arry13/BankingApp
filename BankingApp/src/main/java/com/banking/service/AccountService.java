package com.banking.service;

import com.banking.advice.AccountNotFoundException;
import com.banking.advice.InsufficientFundsException;
import com.banking.model.Accounts;

public interface AccountService {
	
	public Accounts createAccount(Accounts account);
	
	public Accounts getAccount(int accountId)throws AccountNotFoundException;
	
	public boolean depositCash(double amount,int accountId)throws AccountNotFoundException;
	
    public boolean withdrawCash(double amount,int accountId)throws AccountNotFoundException,InsufficientFundsException;
	
    public boolean deleteAccount(int accountId) throws AccountNotFoundException;

    public boolean transferAmount(int amount,int accountId1,int accountId2)throws AccountNotFoundException,InsufficientFundsException;
}
