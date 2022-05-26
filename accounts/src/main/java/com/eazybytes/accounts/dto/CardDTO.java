package com.eazybytes.accounts.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class CardDTO {

    private int cardId;

    private int customerId;

    private String cardNumber;

    private String cardType;

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;

    private Date createDt;

}