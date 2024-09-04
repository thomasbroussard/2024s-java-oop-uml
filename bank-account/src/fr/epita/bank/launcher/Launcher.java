package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Customer;

public class Launcher {

    public static void main(String[] args) {
        Customer customer = new Customer("Thomas", "Paris");
        System.out.println(customer);
    }
}
