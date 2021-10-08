package br.com.nimble.nimbleapi.api.Person;

import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.service.Person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Person getById(@PathVariable Long id) {
        return this.service.getById(id);
    }

    @CrossOrigin
    @Transactional
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        this.service.deleteById(id);
    }

    @CrossOrigin
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET, value = "/get/person-list/rule")
    public ResponseEntity getListPersonByRule(@RequestParam(value = "rule") String rule, @RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(this.service.getPersonListByRule(rule, PageRequest.of(page,size)));
    }
}

