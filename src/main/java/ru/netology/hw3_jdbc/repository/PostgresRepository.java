package ru.netology.hw3_jdbc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.hw3_jdbc.entity.Person;

import java.util.List;
import java.util.Optional;


@Repository
public interface PostgresRepository extends JpaRepository<Person, Long> {

    @Query("select p from Person p where p.cityOfLiving = :city")
    List<Person> findByCityOfLiving(@Param("city") String city);

    @Query("select p from Person p where p.age < :age order by p.age asc")
    List<Person> findByAgeLessThanOrderByAgeAsc(@Param("age") int age);

    @Query("select p from Person p where lower(p.name) = lower(:name) and lower(p.surname) = lower(:surname)")
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}