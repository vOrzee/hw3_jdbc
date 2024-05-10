package ru.netology.hw3_jdbc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.hw3_jdbc.repository.PostgresRepository;

@Service
public class PostgresServices {

    @Autowired
    PostgresRepository repository;

    public String getProductName(String name) {
        return repository.getProductName(name);
    }
}
