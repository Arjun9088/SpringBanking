package com.arjun.beginspring.service;

import com.arjun.beginspring.model.Account;
import com.example.beginspring.exceptions.InsufficientFundsException;
import com.example.beginspring.exceptions.UserNotFoundException;

public interface AccountService {
	public void transferMoney(long src, long dest, double amount) throws InsufficientFundsException, UserNotFoundException;

	public void depositMoney(long accountId, double amount) throws UserNotFoundException;

	public void withdrawMoney(long accountId, double amount) throws UserNotFoundException, InsufficientFundsException;

	public Account findAccount(long accountId) throws UserNotFoundException;
	
}
