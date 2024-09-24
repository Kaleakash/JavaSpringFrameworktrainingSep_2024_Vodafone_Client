package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Account;
import com.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public String createAccount(Account account) {
		if(accountRepository.existsById(account.getAccno())) {
			return "Account number already present";
		}else {
			accountRepository.save(account);
			return "Account created successfully";
		}
	}
	
	public String withdrawn(Account account) {		// which we pass which contains accno and amount (accno,amonttodrawn)
		Optional<Account> result = accountRepository.findById(account.getAccno());
		if(result.isPresent()) {
			Account acc = result.get();		// get from db 
			if(acc.getAmount() >= account.getAmount()) {		// acc.getAmount() present in db > account.getAmount() which we can to withdraw 
				acc.setAmount(acc.getAmount()-account.getAmount());
				accountRepository.saveAndFlush(acc);
				return "Amount withdrwan succesfully";
			}else {
				return "You can't withdraw, amount not present";
			}
			
		}else {
			return "Account not exists";
		}
	}
	
	public String deposit(Account account) {
		Optional<Account> result = accountRepository.findById(account.getAccno());
		if(result.isPresent()) {
			Account acc = result.get();
			acc.setAmount(acc.getAmount()+account.getAmount());
			accountRepository.saveAndFlush(acc);
			return "Amount Deposit succesfully";
			
		}else {
			return "Account not exists";
		}
	}
	
	public String findBalance(int accno) {
		Optional<Account> result = accountRepository.findById(accno);
		if(result.isPresent()) {
			Account acc = result.get();
			return "Your balance amount is "+acc.getAmount();
		}else {
			return "Invalid account number ";
		}
	}	
	
	public int findAccno(String emailid) {
		return accountRepository.findAccountUsingEmailiId(emailid);
	}
}
