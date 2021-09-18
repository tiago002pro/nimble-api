package br.com.nimble.nimbleapi.api.Person;

import br.com.nimble.nimbleapi.model.Person.Individual;
import br.com.nimble.nimbleapi.service.Person.IndividualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/person-individual")
public class IndividualAPI {

    @Autowired
    IndividualService service;

    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "/form")
    public Individual setJuridicalPerson(@RequestBody Map<String, String> json)  {
        return this.service.createPF(json);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public List<Individual> getJuridicalPerson() {
        return this.service.getLisPF();
    }
}
