package softleak;

import java.util.Optional;

public class ProcessCustomerTask implements Runnable{
    private CustomerManager customerManager;

    public ProcessCustomerTask(CustomerManager customerManager) {
        this.customerManager = customerManager;
    }


    @Override
    public void run() {
        while (true) {
            Optional<Customer> customer = customerManager.getCustomer();
            if (customer.isEmpty()) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {

            }
        }
    }
}
