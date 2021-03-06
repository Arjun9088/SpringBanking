package com.arjun.beginspring.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arjun.beginspring.service.AccountService;
import com.example.beginspring.exceptions.InsufficientFundsException;
import com.example.beginspring.exceptions.UserNotFoundException;

public class MainClass 
{
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		AccountService acs = applicationContext.getBean("accountService",AccountService.class);
		System.out.println("Before Transfer");
		try {
			System.out.println("Acc 1 balance before transfer: " + acs.findAccount(1).getBalance());
			System.out.println("Acc 2 balance before transfer: " + acs.findAccount(2).getBalance());
			acs.transferMoney(1, 2, 10.0);
			System.out.println("Acc 1 balance after transfer: " + acs.findAccount(1).getBalance());
			System.out.println("Acc 2 balance after transfer: " + acs.findAccount(2).getBalance());
		} catch (InsufficientFundsException | UserNotFoundException e) {
			e.printStackTrace();
		}
	}
}
