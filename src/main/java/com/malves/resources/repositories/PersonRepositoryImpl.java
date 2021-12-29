package com.malves.resources.repositories;

import com.malves.domain.entities.Person;
import com.malves.domain.repository.PersonRepository;
import com.malves.resources.repositories.entities.PersonSchema;
import io.micronaut.data.annotation.Repository;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;

@Singleton
@Transactional
@Repository
public class PersonRepositoryImpl {

    private final PersonRepository personRepository;

    public PersonRepositoryImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {
        return personRepository.save(
                new PersonSchema(
                        person.getName(),
                        person.getAge()
                )).toPerson();
    }
}
