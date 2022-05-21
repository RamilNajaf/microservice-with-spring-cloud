
package com.eazybytes.loans.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.eazybytes.loans.model.Customer;
import com.eazybytes.loans.model.Loans;
import com.eazybytes.loans.repository.LoansRepository;



@RestController
public class LoansController {

	@Autowired
	private LoansRepository loansRepository;

	@GetMapping("/myLoans")
	public List<Loans> getLoansDetails(@RequestBody Customer customer) {
		List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
		if (loans != null) {
			return loans;
		} else {
			return null;
		}

	}

}
