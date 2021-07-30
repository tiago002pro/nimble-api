package br.com.nimble.nimbleapi.service;

import br.com.nimble.nimbleapi.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    ArrayList<Person> personList = new ArrayList<>();

    public String createPerson(Map<String, String> json) {
        Person person = new Person(json.get("Nome:"), json.get("Idade:"));
        personList.add(person);
        return "Pessoa Cadastrada com sucesso";
    }

    public List<Person> getLisPerson() {
        return this.personList;
    }
}
