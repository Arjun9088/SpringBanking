package com.arjun.beginspring.service;

import com.arjun.beginspring.dao.AccountDao;
import com.arjun.beginspring.model.Account;
import com.example.beginspring.exceptions.InsufficientFundsException;
import com.example.beginspring.exceptions.UserNotFoundException;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	
	public void setAccountDao(AccountDao accountDao)
	{
		this.accountDao = accountDao;
	}

	public void transferMoney(long src, long dest, double amount) throws UserNotFoundException, InsufficientFundsException 
	{
		withdrawMoney(src, amount);
		depositMoney(dest, amount);
	}

	public void depositMoney(long accountId, double amount) throws UserNotFoundException {
		Account acc = accountDao.find(accountId);
		if (acc == null) {
			throw new UserNotFoundException("Invalid Account");
		}
		acc.UpdateBalance(amount);

	}

	public void withdrawMoney(long accountId, double amount) throws UserNotFoundException, InsufficientFundsException {
		Account acc = accountDao.find(accountId);
		if (acc == null) {
			throw new UserNotFoundException("Invalid Account");
		}
		if (acc.getBalance() < amount) {
			throw new InsufficientFundsException("Insufficient funds avaiable");
		}
		acc.UpdateBalance(-amount);
	}

	public Account findAccount(long accountId) throws UserNotFoundException {
		Account acc = accountDao.find(accountId);
		if (acc == null) {
			throw new UserNotFoundException("Invalid Account");
		}
		return acc;

	}

}
