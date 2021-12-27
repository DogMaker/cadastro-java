package com.malves.domain.repository;

import com.malves.domain.entities.Person;

import java.util.List;

public interface PersonRepository {

    public Person getPerson(Long id);
    public List<Person> getListPersons();
    public void savePerson(Person person);
    public void updatePerson(Person person);
    public void deletePerson(Long id);
}
