package ru.netology.hw3_jdbc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.hw3_jdbc.entity.Person;
import ru.netology.hw3_jdbc.repository.PostgresRepository;

import java.util.List;

@Service
public class PostgresServices {

    @Autowired
    PostgresRepository repository;

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}
