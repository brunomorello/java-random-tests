package softleak;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CustomerManager {

    private List<Customer> customerList = new ArrayList<>();
    private int nextAvailableId = 0;
    private int lastProcessedId = -1;

    public void addCusomter(Customer customer) {
        synchronized (this) {
            customer.setId(nextAvailableId);
            synchronized (customerList) {
                customerList.add(customer);
            }
            nextAvailableId++;
        }
    }

    // Generating an OOM error
    public Optional<Customer> getCustomer() {
        if (lastProcessedId + 1 > nextAvailableId) {
            lastProcessedId++;
            return Optional.of(customerList.get(0));
        }
        return Optional.empty();
        // Solution:
//        synchronized (customerList) {
//            if (customerList.size() > 0) {
//                return Optional.of(customerList.remove(0));
//            }
//        }
//        return Optional.empty();
    }

    public void howManyCustomers() {
        int size = 0;
        size = customerList.size();
        System.out.println(new Date() + " Customers in queue: " + size + " of " + nextAvailableId);
    }
}
