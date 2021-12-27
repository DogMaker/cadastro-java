package com.malves.resources.repositories;

import com.malves.domain.entities.Person;
import com.malves.domain.repository.PersonRepository;
import com.malves.resources.repositories.entities.PersonSchema;
import io.micronaut.data.annotation.Repository;
import jakarta.inject.Singleton;

import javax.transaction.Transactional;
import java.util.Optional;

@Singleton
@Transactional
@Repository
public class PersonRepositoryImpl {

    private final PersonRepository personRepository;

    public PersonRepositoryImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<PersonSchema> savePerson(Person person) {
        return personRepository.findById(person.getId()).map(personId ->
                personRepository.save(
                        new PersonSchema(
                                person.getId(),
                                person.getName(),
                                person.getAge()
                        )
                )
        );
    }
}
