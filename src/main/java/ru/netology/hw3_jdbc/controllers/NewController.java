package ru.netology.hw3_jdbc.controllers;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hw3_jdbc.entity.Person;
import ru.netology.hw3_jdbc.services.PostgresServices;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/new-controller")
public class NewController {

    @Autowired
    PostgresServices service;

    @GetMapping("/by-city")
    @Secured("ROLE_READ")
    public List<Person> findByCityOfLiving(@RequestParam("city") String city) {
        return service.findByCityOfLiving(city);
    }

    @GetMapping("/by-age")
    @RolesAllowed("ROLE_WRITE")
    public List<Person> findByAgeLessThan(@RequestParam("age") int age) {
        return service.findByAgeLessThan(age);
    }

    @GetMapping("/by-name-and-surname")
    @PreAuthorize("hasRole('ROLE_READ') or hasRole('ROLE_WRITE')")
    public Optional<Person> findByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.findByNameAndSurname(name, surname);
    }

    @GetMapping("/by-city-secured")
    @PostAuthorize("#username == authentication.principal.username")
    public List<Person> getPersonsByCity(@RequestParam("username") String username, @RequestParam("city") String city) {
        System.out.println("Вызвал " + username);
        return service.findByCityOfLiving(city);
    }

}
