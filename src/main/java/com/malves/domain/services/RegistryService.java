package com.malves.domain.services;

import com.malves.domain.RegistryInterface;
import com.malves.domain.entities.Person;
import com.malves.resources.repositories.PersonRepositoryImpl;
import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;

@Singleton
@Primary
public class RegistryService implements RegistryInterface {

    private final PersonRepositoryImpl personRepository;

    public RegistryService(PersonRepositoryImpl personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.savePerson(person);
    }
}
