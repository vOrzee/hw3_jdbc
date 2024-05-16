package ru.netology.hw3_jdbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hw3_jdbc.entity.Person;

import java.util.List;
import java.util.Optional;


@Repository
public interface PostgresRepository extends JpaRepository<Person, Long> {

    List<Person> findByCityOfLiving(String city);

    List<Person> findByAgeLessThanOrderByAgeAsc(int age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}