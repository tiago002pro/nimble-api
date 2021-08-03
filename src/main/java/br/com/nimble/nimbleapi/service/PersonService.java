package br.com.nimble.nimbleapi.service;

import br.com.nimble.nimbleapi.model.Person;
import br.com.nimble.nimbleapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        person.setSexo((String) json.get("sexo"));
        person.setCpf((String) json.get("cpf"));
        person.setRg((String) json.get("rg"));
        person.setCnpj((String) json.get("cnpj"));
        person.setIe((String) json.get("ie"));
        person.setBirthDate((Date) json.get("DataNascimento"));
        this.repository.save(person);

        return "Pessoa Cadastrada com sucesso";
    }

    public List<Person> getLisPerson() {
        return this.repository.findAll();
    }
}
