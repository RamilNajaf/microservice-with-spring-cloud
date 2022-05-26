package com.eazybytes.accounts.service.client;


import com.eazybytes.accounts.entity.Customer;
import com.eazybytes.accounts.dto.CardDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("CARDS")
public interface CardsFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "myCards", consumes = "application/json")
    List<CardDTO> getCardDetails(@RequestBody Customer customer);
}
