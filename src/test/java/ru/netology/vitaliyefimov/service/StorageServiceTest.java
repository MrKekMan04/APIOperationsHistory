package ru.netology.vitaliyefimov.service;

import org.junit.jupiter.api.Test;
import ru.netology.vitaliyefimov.entity.Currency;
import ru.netology.vitaliyefimov.entity.Operation;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class StorageServiceTest {
    @Test
    public void assertThatStorageServiceWorksRight() {
        StorageService<Operation> operationStorageService = new StorageService<>();
        int id = 1;
        int sum = 100;
        Currency currency = Currency.RUB;
        String merchant = "Shoko";

        Operation operation = new Operation(id, sum, currency, merchant);

        operationStorageService.addElement(operation);

        Operation storageOperation = operationStorageService.getElement(0);
        assertEquals(id, storageOperation.getId());
        assertEquals(sum, storageOperation.getSum());
        assertEquals(currency, storageOperation.getCurrency());
        assertEquals(merchant, storageOperation.getMerchant());
    }
}