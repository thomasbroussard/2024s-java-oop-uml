package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.*;

public class Launcher {

    public static void main(String[] args) {
        Customer customer = new Customer("Thomas", "Paris");
        System.out.println(customer);
        SavingsAccount savingsAccount = new SavingsAccount(30.0, customer, 3.0);

        savingsAccount.setBalance(33.0);

        //do a scenario where a customer buys some stock actions of gold ("GOLD"),
        // unit price 55€
        Stock stock = new Stock("GOLD", 55);

        //from his investment account, initialized with 3045€.
        InvestmentAccount investmentAccount = new InvestmentAccount(3045, customer);

        // he buys 5 stock actions.
        double commissionRate =  5;
        StockOrder order = new StockOrder(55, 5, 5, investmentAccount, stock);
        double cost = (order.getUnitPrice() * order.getQuantity() ) * (1 + commissionRate / 100);
        investmentAccount.setBalance(investmentAccount.getBalance() - cost);

        // display the final balance in the console
        System.out.println(investmentAccount.getBalance());

    }
}
