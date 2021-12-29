package com.malves.rest.controllers;

import com.malves.domain.RegistryInterface;
import com.malves.domain.entities.Person;
import com.malves.rest.controllers.dto.PersonDto;
import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;


@Controller("/cadastro")
public class RegistryController {

    protected RegistryInterface registryInterface;

    public RegistryController(RegistryInterface registryInterface) {
        this.registryInterface = registryInterface;
    }

    @Post("/registrar")
    @SingleResult
    public HttpResponse<?> registro(@Body PersonDto personDto) {
        Person person = personDto.toPerson();
        Person response = registryInterface.savePerson(person);

        return HttpResponse.status(HttpStatus.CREATED)
                .body(response);
    }
}
