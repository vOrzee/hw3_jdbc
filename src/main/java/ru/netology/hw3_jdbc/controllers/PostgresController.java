package ru.netology.hw3_jdbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hw3_jdbc.entity.Person;
import ru.netology.hw3_jdbc.services.PostgresServices;

import java.util.List;


@RestController
@RequestMapping("/persons")
public class PostgresController {

    @Autowired
    PostgresServices service;

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }
}
