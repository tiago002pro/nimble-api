package br.com.nimble.nimbleapi.api.Person;

import br.com.nimble.nimbleapi.model.Person.Individual;
import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.service.Person.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/person-individual")
public class IndividualAPI {

    @Autowired
    IndividualService service;

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/form")
    public Individual setJuridicalPerson(@RequestBody Individual resource)  {
        return this.service.createPF(resource);
    }
}
