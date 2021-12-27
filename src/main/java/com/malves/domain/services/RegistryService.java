package com.malves.domain.services;

import com.malves.domain.RegistryInterface;
import com.malves.domain.entities.Person;
import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;

@Singleton
@Primary
public class RegistryService implements RegistryInterface {

    @Override
    public void savePerson(Person person) {
        System.out.println(person);
    }
}
