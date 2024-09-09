package fr.epita.bank.datamodel;

import java.math.BigDecimal;

public class Account {

    private double balance;

    private Customer owner;


    public Account(double balance, Customer owner) {
        this.balance = balance;
        this.owner = owner;
    }
}
