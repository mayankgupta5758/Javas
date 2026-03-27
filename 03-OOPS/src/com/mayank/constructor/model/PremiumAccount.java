package com.mayank.constructor.model;

public class PremiumAccount extends BankAccount {

    static int additionalAmount = 1000;

    public PremiumAccount(String accountHolderName, double balance) {
        super(accountHolderName, balance);
    }
}
