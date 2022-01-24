package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.*;
import br.com.nimble.nimbleapi.repository.Person.JuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JuridicaService {
    @Autowired
    JuridicaRepository repository;

    public Juridica createPJ(Juridica resource) {
         this.repository.save(resource);
         return resource;
    }
}