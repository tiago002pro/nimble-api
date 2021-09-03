package br.com.nimble.nimbleapi.service.Person;

import br.com.nimble.nimbleapi.model.Person.Person;
import br.com.nimble.nimbleapi.repository.Person.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public String createPerson(Map<String, Object> json) throws ParseException {
        Person person = new Person();

        person.setName((String) json.get("nome"));
        this.repository.save(person);

        return "Pessoa Cadastrada com sucesso";
    }

    public List<Person> getLisPerson() {
        return this.repository.findAll();
    }
}
