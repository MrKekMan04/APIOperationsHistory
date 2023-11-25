package ru.netology.vitaliyefimov.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.vitaliyefimov.entity.Customer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private Integer id;
    private String name;

    public static CustomerDTO fromCustomer(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getName());
    }
}
