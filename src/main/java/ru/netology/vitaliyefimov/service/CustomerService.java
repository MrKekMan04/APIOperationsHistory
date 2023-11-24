package ru.netology.vitaliyefimov.service;

import org.springframework.stereotype.Service;
import ru.netology.vitaliyefimov.entity.Customer;

@Service
public class CustomerService {
    private final StorageService<Customer> service;

    public CustomerService(StorageService<Customer> service) {
        this.service = service;
    }

    public Customer getCustomer(int index) {
        return service.getElement(index);
    }

    public void addCustomer(Customer customer) {
        service.addElement(customer);
    }

    public int customersCount() {
        return service.size();
    }
}
