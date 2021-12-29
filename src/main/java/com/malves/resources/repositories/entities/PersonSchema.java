package com.malves.resources.repositories.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.malves.domain.entities.Person;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity(name = "Person")
public class PersonSchema {

    public PersonSchema() {
    }

    public PersonSchema(String name, int age) {
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

    public Person toPerson() {
        return new Person(this.id, this.name, this.getAge());
    }
}
