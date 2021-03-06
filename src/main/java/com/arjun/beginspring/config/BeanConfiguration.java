package com.arjun.beginspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arjun.beginspring.dao.AccountDao;
import com.arjun.beginspring.dao.AccountDaoImpl;
import com.arjun.beginspring.service.AccountService;
import com.arjun.beginspring.service.AccountServiceImpl;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public AccountService accountService()
	{
		AccountServiceImpl acs = new AccountServiceImpl();
		acs.setAccountDao(accountDao());
		return acs;
	}
	
	@Bean
	public AccountDao accountDao() 
	{
		AccountDaoImpl adi = new AccountDaoImpl();
		return adi;
	}

}
