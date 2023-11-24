package ru.netology.vitaliyefimov.service;

import org.junit.jupiter.api.Test;
import ru.netology.vitaliyefimov.entity.Currency;
import ru.netology.vitaliyefimov.entity.Operation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationServiceTest {
    @Test
    public void assertThatOperationServiceWorksRight() {
        StorageService<Operation> operationStorageService = new StorageService<>();
        OperationService operationService = new OperationService(operationStorageService);
        int id = 1;
        int sum = 100;
        Currency currency = Currency.RUB;
        String merchant = "Coffee";

        Operation operation = new Operation(id, sum, currency, merchant);

        operationService.addOperation(operation);

        Operation serviceOperation = operationService.getOperation(0);
        assertEquals(operation, serviceOperation);
        assertEquals(id, serviceOperation.getId());
        assertEquals(sum, serviceOperation.getSum());
        assertEquals(currency, serviceOperation.getCurrency());
        assertEquals(merchant, serviceOperation.getMerchant());
    }
}