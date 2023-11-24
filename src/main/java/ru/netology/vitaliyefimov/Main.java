package ru.netology.vitaliyefimov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.netology.vitaliyefimov.config.ApplicationConfiguration;
import ru.netology.vitaliyefimov.exception.CustomerOperationOutOfBoundException;
import ru.netology.vitaliyefimov.service.*;

public class Main {
    public static void main(String[] args) throws CustomerOperationOutOfBoundException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        AsyncInputOperationService asyncInputOperationService = applicationContext.getBean(AsyncInputOperationService.class);
        IOService ioService = applicationContext.getBean(IOService.class);

        ioService.inputData();
        asyncInputOperationService.startAsyncOperationProcessing();
    }
}