package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;
import fr.epita.bank.datamodel.SavingsAccount;

public class Launcher {

    public static void main(String[] args) {
        Customer customer = new Customer("Thomas", "Paris");
        System.out.println(customer);
        SavingsAccount savingsAccount = new SavingsAccount(30.0, customer, 3.0);

        savingsAccount.setBalance(33.0);

        //do a scenario where a customer buys some stock actions of gold ("GOLD"),
        // unit price 55€ from his investment account, initialized with 3045€.
        // he buys 5 stock actions.
        // display the final balance in the console
    }
}
