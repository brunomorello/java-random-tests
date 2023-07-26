package com.bmo.softleak;

public class CustomerHarness {
    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        GenerateCustomerTask generateCustomerTask = new GenerateCustomerTask(customerManager);
        ProcessCustomerTask processCustomerTask = new ProcessCustomerTask(customerManager);

        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(generateCustomerTask);
            thread.start();
        }
        Thread thread = new Thread(processCustomerTask);
        thread.start();

        // main thread is acting as the monitoring thread
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            customerManager.howManyCustomers();
            System.out.println("Available Memory: " + Runtime.getRuntime().freeMemory() / 1024 + "k");
        }
    }
}
