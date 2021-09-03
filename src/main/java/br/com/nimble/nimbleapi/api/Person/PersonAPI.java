package br.com.nimble.nimbleapi.api.Person;

import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.service.Person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/person")
public class PersonAPI {
    @Autowired
    PersonService service;

    @RequestMapping(method = RequestMethod.POST, value = "/form")
    public String setPerson(Map<String, Object> json) throws ParseException {
        return this.service.createPerson(json);
    }

    @GetMapping("/getperson")
    public List<Person> gerListPerson() {
        return this.service.getLisPerson();
    }
}

