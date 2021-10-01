package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.*;
import br.com.nimble.nimbleapi.repository.Person.IndividualRepository;
import br.com.nimble.nimbleapi.repository.Person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public Person getById(Long id) {
        return this.repository.findById(id).get();
    }

    public Page<Person> getPersosList(Pageable pageable) {
        return this.repository.findAll(pageable);
    }


    public Page<Map<String, Object>> getPersonListByRule(String rule, Pageable pageable) {
        return this.repository.findAllPersonByRule(rule, pageable);
    }



    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
}
