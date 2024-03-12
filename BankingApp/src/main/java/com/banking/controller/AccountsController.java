package com.banking.controller;

import org.slf4j.event.LoggingEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.model.Accounts;
import com.banking.service.AccountService;

import ch.qos.logback.classic.Logger;



@RestController
@RequestMapping(value="/accounts")
public class AccountsController {
	@Autowired
	AccountService accountService;
	
	
	@PostMapping("/createaccount")
	public ResponseEntity<Accounts> createAccount(Accounts account){
		
		accountService.createAccount(account);
		return new ResponseEntity<Accounts>(account,HttpStatus.OK);
	}
    
	
	@GetMapping("/getaccount")
	public ResponseEntity<Accounts> getAccount(int accountId){
		Accounts account=accountService.getAccount(accountId);
		return new ResponseEntity<Accounts>(account,HttpStatus.OK);
	}
	
	@PutMapping("/depositcash")
	public ResponseEntity<Boolean> depositCash(double amount,int accountid){
		Boolean res=accountService.depositCash(amount, accountid);
		return new ResponseEntity<Boolean>(res,HttpStatus.OK);
	}
	@PutMapping("/withdrawcash")
	public ResponseEntity<Boolean> withdrawCash(double amount,int accountid){
		Boolean res=accountService.withdrawCash(amount, accountid);
		return new ResponseEntity<Boolean>(res,HttpStatus.OK);
	}
	
    @DeleteMapping("/deleteaccount")
    public ResponseEntity<Boolean> deleteAccount(int accountId){
    	Boolean res=accountService.deleteAccount(accountId);
    	return new ResponseEntity<Boolean>(res,HttpStatus.OK);
    }
	@PutMapping("/transferAmount")
	public ResponseEntity<Boolean> transferAmount(int amount,int accountId1,int accountId2){
		Boolean res =accountService.transferAmount(amount, accountId1, accountId2);
		return new ResponseEntity<Boolean>(res,HttpStatus.OK);
	}
}
