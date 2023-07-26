package com.bmo.softleak;

import java.util.UUID;

public class GenerateCustomerTask implements Runnable {

    private CustomerManager customerManager;

    public GenerateCustomerTask(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            String name = UUID.randomUUID().toString();
            Customer customer = new Customer(name);
            customerManager.addCusomter(customer);
        }
    }
}
