package com.malves.domain.repository;

import com.malves.resources.repositories.entities.PersonSchema;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;


@Repository
public interface PersonRepository extends CrudRepository<PersonSchema, Long> {
}


