package com.eazybytes.accounts.dto;

import com.eazybytes.accounts.entity.Accounts;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CustomerDetailDTO {

    private Accounts accounts;
    private List<LoanDTO> loans;
    private List<CardDTO> cards;



}
