package fr.epita.bank.datamodel;

public class SavingsAccount extends Account {

    private double interestRate;


    public SavingsAccount(double balance, Customer owner, double interestRate) {
        super(balance, owner);
        this.interestRate = interestRate;
    }
}
