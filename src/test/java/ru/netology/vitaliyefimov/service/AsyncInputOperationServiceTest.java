package ru.netology.vitaliyefimov.service;

import org.junit.jupiter.api.Test;
import ru.netology.vitaliyefimov.entity.Operation;

import static org.junit.jupiter.api.Assertions.*;

public class AsyncInputOperationServiceTest {
    @Test
    public void assertThatAsyncInputOperationServiceWorksRight() throws InterruptedException {
        OperationService operationService = new OperationService(new StorageService<>());
        AsyncInputOperationService asyncInputOperationService = new AsyncInputOperationService(operationService);
        asyncInputOperationService.startAsyncOperationProcessing();
        Operation operation = new Operation();

        asyncInputOperationService.offerOperation(operation);
        Thread.sleep(1500);

        Operation serviceOperation = operationService.getOperation(0);
        assertEquals(operation, serviceOperation);
        assertEquals(operation.getId(), serviceOperation.getId());
        assertEquals(operation.getSum(), serviceOperation.getSum());
        assertEquals(operation.getCurrency(), serviceOperation.getCurrency());
        assertEquals(operation.getMerchant(), serviceOperation.getMerchant());
    }
}