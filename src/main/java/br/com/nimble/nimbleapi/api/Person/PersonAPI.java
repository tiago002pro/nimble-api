package br.com.nimble.nimbleapi.api.Person;

import br.com.nimble.nimbleapi.model.Person.Juridica;
import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.service.Person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/person")
public class PersonAPI {
    @Autowired
    PersonService service;

//    @Transactional
//    @RequestMapping(method = RequestMethod.POST, value = "/form/pj")
//    public String setPerson(Map<String, String> json)  {
//        return this.service.createPJ(json);
//    }
//
//    @Transactional
//    @RequestMapping(method = RequestMethod.GET, value = "/get/pj")
//    public List<Juridica> gerListPerson() {
//        return this.service.getLisPerson();
//    }
}

