package com.arjun.beginspring.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Account {

	private long id;
	private String ownerName;
	private double balance;
	private Date accessTime;
	private Boolean locked;
	
	public Account(long id, String ownerName, double balance)
	{
		this.id = id;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public void UpdateBalance(double amount)
	{
		this.balance = this.balance + amount;
	}
	
}
