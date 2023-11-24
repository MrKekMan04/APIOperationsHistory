package ru.netology.vitaliyefimov.service;

import org.springframework.stereotype.Service;
import ru.netology.vitaliyefimov.entity.Operation;

@Service
public class OperationService {
    private final StorageService<Operation> service;

    public OperationService(StorageService<Operation> service) {
        this.service = service;
    }

    public Operation getOperation(int index) {
        return service.getElement(index);
    }

    public void addOperation(Operation operation) {
        service.addElement(operation);
    }
}
