package com.banking.serviceimpl;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.advice.AccountNotFoundException;
import com.banking.advice.InsufficientFundsException;
import com.banking.advice.SameAccountException;
import com.banking.dao.AccountDao;
import com.banking.model.Accounts;
import com.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDao accountDao;

	@Override
	public Accounts createAccount(Accounts account) {
	
		return accountDao.save(account);
	}

	@Override
	public Accounts getAccount(int accountId) throws AccountNotFoundException {
	     Optional<Accounts> account=accountDao.findById(accountId);
		
	     if(account.isEmpty()) {
	    	 throw new AccountNotFoundException("Account Not Found");
	     }
		return account.get() ;
	}

	@Override
	public boolean withdrawCash(double amount, int accountId) throws AccountNotFoundException,InsufficientFundsException {
		Optional<Accounts> account=accountDao.findById(accountId);
		if(account.isEmpty()) {
	    	 throw new AccountNotFoundException("Account Not Found");
	     }
		if(amount<account.get().getBalance()) {
			account.get().setBalance(account.get().getBalance()-amount);
			accountDao.save(account.get());
		}
		else {
			throw new InsufficientFundsException("Insufficient Funds");
		}
		return true;
	}

	@Override
	public boolean depositCash(double amount, int accountId) throws AccountNotFoundException {
		Optional<Accounts> account=accountDao.findById(accountId);
		if(account.isEmpty()) {
			throw new AccountNotFoundException("Account Not Found");
		}
	
		account.get().setBalance(account.get().getBalance()+amount);
		accountDao.save(account.get());
		
		return true;
	}

	@Override
	public boolean deleteAccount(int accountId) throws AccountNotFoundException {
		Optional <Accounts> account=accountDao.findById(accountId);
		if(account.isEmpty()) {
			throw new AccountNotFoundException("Account Not Found");
		}
		 accountDao.deleteById(accountId);
		 return true;
	}

	@Override
	public boolean transferAmount(int amount, int accountId1, int accountId2)
			throws AccountNotFoundException, InsufficientFundsException {
		Optional <Accounts> account1 =accountDao.findById(accountId1);
		Optional <Accounts> account2 =accountDao.findById(accountId2);
		if(account1.equals(account2))
			throw new SameAccountException("Cannot transfer to same account");
		if(account1.isEmpty()||account2.isEmpty())
			throw new AccountNotFoundException("Account does not exist");
		
		//withdraw from account 1
		if(amount<account1.get().getBalance()) {
			account1.get().setBalance(account1.get().getBalance()-amount);
			accountDao.save(account1.get());
		}
		else {
			throw new InsufficientFundsException("Insufficient Funds");
		}
		
		//deposit in account 2
		account2.get().setBalance(account2.get().getBalance()+amount);
		accountDao.save(account2.get());
		
		return true;
		
		
	}
	

	

}
