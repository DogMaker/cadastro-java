package com.malves.domain.entities;

import io.micronaut.core.annotation.Introspected;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Random;

@Entity
@Introspected
@Table(name = "person", schema = "dbo")
public class Person {

    public Person() { }

    public Person(String name, int age) {
        this(1L, name, age);
    }

    public Person(Long id, String name, int age) {
        if(id.longValue() == 1) {
            this.id = generateId();
        }
        this.name = name;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator="course")
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
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
