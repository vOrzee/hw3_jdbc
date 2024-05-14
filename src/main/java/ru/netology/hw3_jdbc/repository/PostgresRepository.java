package ru.netology.hw3_jdbc.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.hw3_jdbc.entity.Order;


import java.util.List;

@Repository
public class PostgresRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Order> findOrdersByCustomerName(String name) {
        String queryString = """
                SELECT o FROM Order o
                WHERE lower(o.customer.name) = lower(:name)
                """.stripIndent();
        return entityManager.createQuery(queryString, Order.class)
                .setParameter("name", name)
                .getResultList();
    }

}
