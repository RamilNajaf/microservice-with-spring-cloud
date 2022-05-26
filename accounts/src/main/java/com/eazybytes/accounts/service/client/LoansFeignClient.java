package com.eazybytes.accounts.service.client;

import com.eazybytes.accounts.entity.Customer;

import com.eazybytes.accounts.dto.LoanDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("LOANS")
public interface LoansFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "myLoans", consumes = "application/json")
    List<LoanDTO> getLoansDetails(@RequestBody Customer customer);
}
