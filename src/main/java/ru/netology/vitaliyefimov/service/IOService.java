package ru.netology.vitaliyefimov.service;

import org.springframework.stereotype.Service;
import ru.netology.vitaliyefimov.entity.Currency;
import ru.netology.vitaliyefimov.entity.Customer;
import ru.netology.vitaliyefimov.entity.Operation;
import ru.netology.vitaliyefimov.exception.CustomerOperationOutOfBoundException;

import java.util.InputMismatchException;
import java.util.Scanner;

@Service
public class IOService {
    private final Scanner scanner = new Scanner(System.in);
    private final CustomerService customerService;
    private final StatementService statementService;
    private final AsyncInputOperationService asyncInputOperationService;

    public IOService(CustomerService customerService,
                     StatementService statementService,
                     AsyncInputOperationService asyncInputOperationService) {
        this.customerService = customerService;
        this.statementService = statementService;
        this.asyncInputOperationService = asyncInputOperationService;
    }

    public void inputData() {
        inputClients();
        inputOperations();
        getOperations();
    }

    private void inputClients() {
        int clientID = 0;

        while (true) {
            System.out.println("Client name: ");
            String name = scanner.nextLine();
            Customer customer = new Customer(clientID, name);

            customerService.addCustomer(customer);
            clientID++;

            System.out.println("Do yo wont to enter next client? Y/N");
            String answer = scanner.nextLine();

            if (answer.equals("N")) {
                break;
            }
        }
    }

    private void inputOperations() throws CustomerOperationOutOfBoundException {
        int operationId = 0;

        while (true) {
            int sum;

            while (true) {
                try {
                    System.out.println("Sum: ");
                    sum = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Сумма должна быть задана числом");
                    scanner.next();
                }
            }

            System.out.println("Currency: ");
            String currency = scanner.nextLine();

            System.out.println("Merchant: ");
            String merchant = scanner.nextLine();

            Operation operation = new Operation(operationId, sum, Enum.valueOf(Currency.class, currency), merchant);
            asyncInputOperationService.offerOperation(operation);
            operationId++;

            int clientId;

            while (true) {
                try {
                    System.out.println("ClientID: ");
                    clientId = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Id клиента должно быть задано числом");
                    scanner.next();
                }
            }

            saveOperation(clientId, operation);

            System.out.println("Do yo wont to enter next operation? Y/N");
            String answer = scanner.nextLine();

            if (answer.equals("N")) {
                break;
            }
        }
    }

    private void getOperations() {
        while (true) {
            System.out.println("Enter the client ID");
            int clientId = scanner.nextInt();
            scanner.nextLine();

            if (clientId >= customerService.customersCount()) {
                System.out.println("Введён несуществующий ID\n");
                continue;
            }

            statementService.getCustomerOperations(clientId)
                    .forEach(System.out::println);

            System.out.println("Do yo wont to enter next clientID? Y/N");
            String answer = scanner.nextLine();

            if (answer.equals("N")) {
                break;
            }
        }
    }

    private void saveOperation(int clientId, Operation operation) {
        statementService.setOperation(clientId, operation);
    }
}
