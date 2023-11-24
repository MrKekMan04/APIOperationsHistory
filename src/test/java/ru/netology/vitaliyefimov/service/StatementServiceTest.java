package ru.netology.vitaliyefimov.service;

import org.junit.jupiter.api.Test;
import ru.netology.vitaliyefimov.entity.Currency;
import ru.netology.vitaliyefimov.entity.Operation;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementServiceTest {
    @Test
    public void assertThatStatementServiceWorksRight() {
        StatementService statementService = new StatementService();
        int operationId = 2;
        int operationClientId = 0;
        int clientId = 1;
        int operationSum = 100;
        Currency operationCurrency = Currency.USD;
        String operationMerchant = "Coffee";

        Operation operation = new Operation(operationId, operationSum, operationCurrency, operationMerchant);
        statementService.setOperation(clientId, operation);
        Operation serviceOperation = statementService.getOperation(clientId, operationClientId);

        assertEquals(Map.of(clientId, List.of(operation)), statementService.getStatement());
        assertEquals(operation, serviceOperation);
        assertEquals(operationId, serviceOperation.getId());
        assertEquals(operationSum, serviceOperation.getSum());
        assertEquals(operationCurrency, serviceOperation.getCurrency());
        assertEquals(operationMerchant, serviceOperation.getMerchant());
    }
}