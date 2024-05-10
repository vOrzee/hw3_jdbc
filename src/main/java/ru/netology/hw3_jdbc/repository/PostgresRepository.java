package ru.netology.hw3_jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PostgresRepository {


    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final String findProductsCustomer;

    @Autowired
    public PostgresRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        findProductsCustomer = read("step3.sql");
    }

    public String getProductName(String name) {
        Map<String, Object> params = Map.of("name", name);
        return jdbcTemplate.query(findProductsCustomer, params, (rs, rowNum) -> rs.getString("product_name")).toString();
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream(); BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
