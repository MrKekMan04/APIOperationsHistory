package ru.netology.vitaliyefimov.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StorageService<T> {
    private final List<T> storage;

    public StorageService() {
        this.storage = new ArrayList<>();
    }

    public T getElement(int index) {
        return storage.get(index);
    }

    public void addElement(T element) {
        storage.add(element);
    }

    public int size() {
        return storage.size();
    }
}
