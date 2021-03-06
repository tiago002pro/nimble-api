package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.*;
import br.com.nimble.nimbleapi.repository.Person.IndividualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndividualService {
    @Autowired
    IndividualRepository repository;

    public Individual createPF(Individual resource) {
        this.repository.save(resource);
        return resource;
    }
}