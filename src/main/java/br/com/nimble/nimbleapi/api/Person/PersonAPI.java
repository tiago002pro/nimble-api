package br.com.nimble.nimbleapi.api.Person;

import br.com.nimble.nimbleapi.model.Person.Juridica;
import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.service.Person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonAPI {
    @Autowired
    PersonService service;

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/get/person-list")
    public List<Person> gerListPerson() {
        return this.service.getPersosList();
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/get/person-list/rule")
    public List<Person> getListPersonByRule(@RequestParam String rule) {
        return this.service.getPersonListByRule(rule);
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Person getById(@PathVariable Long id) {
        return this.service.getById(id);
    }
}

