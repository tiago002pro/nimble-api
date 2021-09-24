package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.*;
import br.com.nimble.nimbleapi.repository.Person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public Person getById(Long id) {
        return this.repository.findById(id).get();
    }

    public List<Person> getPersonListByRule(String rule) {
        return this.repository.findAllPersonByRule(rule);
    }

    public Page<Person> getPersosList(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
}
