package ru.netology.vitaliyefimov.service;

import org.junit.jupiter.api.Test;
import ru.netology.vitaliyefimov.entity.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceTest {
    @Test
    public void assertThatCustomerServiceWorksRight() {
        StorageService<Customer> customerStorageService = new StorageService<>();
        CustomerService customerService = new CustomerService(customerStorageService);
        int id = 1;
        String name = "Peter";
        Customer peter = new Customer(id, name);

        customerService.addCustomer(peter);
        Customer customer = customerService.getCustomer(0);

        assertEquals(peter, customer);
        assertEquals(id, customer.getID());
        assertEquals(name, customer.getName());
    }
}