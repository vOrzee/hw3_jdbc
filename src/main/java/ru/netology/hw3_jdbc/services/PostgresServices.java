package ru.netology.hw3_jdbc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.hw3_jdbc.entity.Person;
import ru.netology.hw3_jdbc.repository.PostgresRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostgresServices {

    @Autowired
    private PostgresRepository repository;

    public List<Person> findByCityOfLiving(String city) {
        return repository.findByCityOfLiving(city);
    }

    public List<Person> findByAgeLessThan(int age) {
        return repository.findByAgeLessThanOrderByAgeAsc(age);
    }

    public Optional<Person> findByNameAndSurname(String name, String surname) {
        return repository.findByNameAndSurname(name, surname);
    }

}
