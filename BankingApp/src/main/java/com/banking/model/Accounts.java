package com.banking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Accounts {
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
		private int accountId;
		private double balance;
		private String status;
	    @OneToOne
	    @JoinColumn(name="fkcustomerId")
	    Customer customer;
		
	  
      
}
