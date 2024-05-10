package ru.netology.hw3_jdbc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hw3_jdbc.services.PostgresServices;


@RestController
@RequestMapping("/products")
public class PostgresController {

    @Autowired
    PostgresServices service;

    @GetMapping("/fetch-product")
    public String getProductName(@RequestParam("name") String name) {
        return service.getProductName(name);
    }
}
