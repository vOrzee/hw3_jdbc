package ru.netology.hw3_jdbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hw3_jdbc.entity.Person;
import ru.netology.hw3_jdbc.services.PostgresServices;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/persons")
public class PostgresController {

    @Autowired
    PostgresServices service;

    @GetMapping("/by-city")
    public List<Person> findByCityOfLiving(@RequestParam("city") String city) {
        return service.findByCityOfLiving(city);
    }

    @GetMapping("/by-age")
    public List<Person> findByAgeLessThan(@RequestParam("age") int age) {
        return service.findByAgeLessThan(age);
    }

    @GetMapping("/by-name-and-surname")
    public Optional<Person> findByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.findByNameAndSurname(name, surname);
    }
}
