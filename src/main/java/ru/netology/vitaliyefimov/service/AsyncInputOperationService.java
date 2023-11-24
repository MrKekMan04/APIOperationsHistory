package ru.netology.vitaliyefimov.service;

import org.springframework.stereotype.Service;
import ru.netology.vitaliyefimov.entity.Operation;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class AsyncInputOperationService {
    private final Queue<Operation> queue = new LinkedList<>();
    private final OperationService operationService;

    public AsyncInputOperationService(OperationService operationService) {
        this.operationService = operationService;
    }

    public boolean offerOperation(Operation operation) {
        return queue.offer(operation);
    }

    public void startAsyncOperationProcessing() {
        Thread t = new Thread(this::processQueue);
        t.start();
    }

    private void processQueue() {
        while (true) {
            Operation operation = queue.poll();

            if (operation == null) {
                try {
                    System.out.println("Waiting for next operation in queue");
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Processing operation:" + operation);

                operationService.addOperation(operation);
            }
        }
    }
}
