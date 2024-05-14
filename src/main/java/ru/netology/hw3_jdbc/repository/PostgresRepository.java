package ru.netology.hw3_jdbc.repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.hw3_jdbc.entity.Person;

import java.util.List;


@Repository
public class PostgresRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        var query = entityManager.createQuery("select p from Person p where p.cityOfLiving = :city", Person.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

}
