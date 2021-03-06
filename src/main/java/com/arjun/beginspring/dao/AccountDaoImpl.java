package com.arjun.beginspring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.arjun.beginspring.model.Account;

public class AccountDaoImpl implements AccountDao {

	private Map<Long, Account> accountsMap = new HashMap<>();

	{
		Account acc1 = new Account(1L, "Arjun", 20.0);
		Account acc2 = new Account(2L, "Balan", 100.0);
		Account acc3 = new Account(3L, "Sabu", 90.0);
		Account acc4 = new Account(4L, "Laxmi", 50.0);
		Account acc5 = new Account(5L, "Chinju", 200.0);

		accountsMap.put(acc1.getId(), acc1);
		accountsMap.put(acc2.getId(), acc2);
		accountsMap.put(acc3.getId(), acc3);
		accountsMap.put(acc4.getId(), acc4);
		accountsMap.put(acc5.getId(), acc5);
	}

	public void insert(Account account) {
		accountsMap.put(account.getId(), account);
	}

	public void update(Account account) {
		accountsMap.put(account.getId(), account);
	}

	public void update(List<Account> accounts) {
		for (Account acc : accounts) {
			accountsMap.put(acc.getId(), acc);
		}
	}

	public void delete(long accountId) {
		accountsMap.remove(accountId);
	}

	public Account find(long accountId) {
		return accountsMap.get(accountId);
	}

	public List<Account> find(List<Long> accountIds) {

		List<Account> accounts = new ArrayList<>();
		accounts.addAll(accountsMap.values());
		return accounts.stream()
				.filter(acc -> accountIds.contains(acc.getId()))
				.collect(Collectors.toList());

	}

	public List<Account> find(String ownerName) {
		List<Account> accounts = new ArrayList<>();
		accounts.addAll(accountsMap.values());
		return accounts.stream()
				.filter(acc -> acc.getOwnerName() == ownerName)
				.collect(Collectors.toList());
	}

	public List<Account> find(boolean locked) {
		return accountsMap.values()
				.stream()
				.filter(acc -> acc.getLocked() == locked)
				.collect(Collectors.toList());
	}

}
