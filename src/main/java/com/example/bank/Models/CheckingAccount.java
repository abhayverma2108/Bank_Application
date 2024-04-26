package com.example.bank.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CheckingAccount extends Account {
//    transactions allowed per day
    private final SimpleIntegerProperty transactionLimit;

    public CheckingAccount(String owner, String accountNumber, Double balance, int tlimit) {
        super(owner, accountNumber, balance);
        this.transactionLimit = new SimpleIntegerProperty(this,"Transaction", tlimit);
    }
    public IntegerProperty transactionLimitProp() {return transactionLimit;}

    }

