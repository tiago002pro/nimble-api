package br.com.nimble.nimbleapi.api;

import br.com.nimble.nimbleapi.model.Person;
import br.com.nimble.nimbleapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PersonAPI {
    @Autowired
    PersonService service;

    @CrossOrigin
    @PostMapping("/cadastro")
    public String setPerson(Map<String, String> json) {
        return this.service.createPerson(json);
    }

    @CrossOrigin
    @GetMapping("/get_list")
    public List<Person> gerListPerson() {
        return this.service.getLisPerson();
    }
}

