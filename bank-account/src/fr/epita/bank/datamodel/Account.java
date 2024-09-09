package fr.epita.bank.datamodel;

import java.math.BigDecimal;

public class Account {

    public double balance;

    private Customer owner;


    public Account(double balance, Customer owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public void setBalance(double newBalance){
        if (newBalance > 0) {
            this.balance = newBalance;
        }
    }

    public double getBalance() {
        return balance;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
