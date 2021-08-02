package br.com.nimble.nimbleapi.service;

import br.com.nimble.nimbleapi.model.Person;
import br.com.nimble.nimbleapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public String createPerson(Map<String, String> json) {
        Person person = new Person();

        person.setName(json.get("nome"));
        person.setEmail(json.get("email"));
        this.repository.save(person);

        return "Pessoa Cadastrada com sucesso";
    }

    public List<Person> getLisPerson() {
        return this.repository.findAll();
    }
}
