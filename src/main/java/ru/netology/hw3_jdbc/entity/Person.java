package ru.netology.hw3_jdbc.entity;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String surname;

    private int age;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "city_of_living", length = 20)
    private String cityOfLiving;
}