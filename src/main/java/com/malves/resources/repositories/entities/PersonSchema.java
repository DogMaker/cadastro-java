package com.malves.resources.repositories.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.malves.domain.entities.Person;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Random;


@Entity(name = "Person")
public class PersonSchema {

    public PersonSchema() {
    }

    public PersonSchema(String name, int age) {
        this(1L, name, age);
    }

    public PersonSchema(Long id, String name, int age) {
        if (id == 1) {
            this.id = generateId();
        }
        this.name = name;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "can not be empty")
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;

    @Min(18)
    @Column(name = "age")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long generateId() {
        long num = 0;
        Random random = new Random();

        for (int i = 1; i <= 2; i++) {
            num = random.nextInt(10000);
        }
        return num;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        com.malves.domain.entities.Person person = new com.malves.domain.entities.Person(id, name, age);

        try {
            return mapper.writeValueAsString(person);
        } catch (JsonProcessingException e) {
            throw new Error("It not possible to convert as string");
        }
    }
}