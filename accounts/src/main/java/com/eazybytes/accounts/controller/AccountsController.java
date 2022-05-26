/**
 * 
 */
package com.eazybytes.accounts.controller;

import com.eazybytes.accounts.service.client.CardsFeignClient;
import com.eazybytes.accounts.service.client.LoansFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eazybytes.accounts.entity.Accounts;
import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.dto.*;

import java.util.List;


@RestController
public class AccountsController {

	private final AccountsRepository accountsRepository;

	private final CardsFeignClient cardsFeignClient;

	private final LoansFeignClient loansFeignClient;

	public AccountsController(AccountsRepository accountsRepository, CardsFeignClient cardsFeignClient, LoansFeignClient loansFeignClient) {
		this.accountsRepository = accountsRepository;
		this.cardsFeignClient = cardsFeignClient;
		this.loansFeignClient = loansFeignClient;
	}

	@GetMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {

		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
		if (accounts != null) {
			return accounts;
		} else {
			return null;
		}

	}


	@PostMapping("/myCustomerDetails")
	public CustomerDetailDTO myCustomerDetails(@RequestBody Customer customer) {

		Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());

		List<LoanDTO> loans = loansFeignClient.getLoansDetails(customer);
		List<CardDTO> cards = cardsFeignClient.getCardDetails(customer);

		CustomerDetailDTO customerDetails = new CustomerDetailDTO();
		customerDetails.setAccounts(accounts);
		customerDetails.setLoans(loans);
		customerDetails.setCards(cards);

		return customerDetails;

	}

}
